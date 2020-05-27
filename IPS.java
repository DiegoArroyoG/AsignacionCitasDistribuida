import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IPS implements iIPS {
    String insIP;
    HashMap<String, String[]> epses = new HashMap<String, String[]>();
    HashMap<String, Integer> clientes = new HashMap<String, Integer>();
    List<Cita> citas;

    @Override
    public String asignarCita(String ip, int puerto, String documento, String eps, String fiebre, String tos, String cansancio, String dolor,
                              String difRespirar, String insPulmonar, String shockSeptico, String fallaOrganica, String patologia, String cirugia)
        throws RemoteException, NotBoundException {
        System.out.println(epses.get(eps));
        Registry registry = LocateRegistry
            .getRegistry(epses.get(eps)[0], Integer.parseInt(epses.get(eps)[1]) );
        iEPS rmiEps = (iEPS) registry.lookup("eps");
        int edad = Integer.parseInt(rmiEps.verificarExistencia(documento));
        int peso;
        // hacer validacion de peso
        if(edad!=-1){
            registry = LocateRegistry.getRegistry(insIP, Configuracion.INS);
            iINS rmiIns = (iINS) registry.lookup("ins");
            peso = rmiIns.evaluarPaciente(
                    edad,
                    fiebre.equalsIgnoreCase("si"),
                    tos.equalsIgnoreCase("si"),
                    cansancio.equalsIgnoreCase("si"),
                    dolor.equalsIgnoreCase("si"),
                    difRespirar.equalsIgnoreCase("si"),
                    insPulmonar.equalsIgnoreCase("si"),
                    shockSeptico.equalsIgnoreCase("si"),
                    fallaOrganica.equalsIgnoreCase("si"),
                    patologia.equalsIgnoreCase("si"),
                    cirugia.equalsIgnoreCase("si")
                    );
            return evaluarPeso(peso, documento, edad, ip, puerto);
            // return "Paciente de documento "+ documento + " tiene "+ edad + " años\n";
        }
        return "Paciente no encontrado en dicha EPS";
    }

    String agregarCita(boolean prioritaria, String documento, String ip, int puerto) throws RemoteException, NotBoundException
    {
        // por si acaso
        if(this.citas == null) this.citas = new ArrayList<Cita>();

        int hora = 0;

        if (citas.isEmpty() || !prioritaria)
        {
            citas.add(new Cita(ip, puerto, documento, prioritaria) );
        }
        else // esta es prioritaria
        {
            for( Cita c : this.citas )
            {
                if( !c.esPrioritaria() )
                {
                    break;
                }
                hora++;
            }

            if(hora != this.citas.size())
            {
                EnviarMensajeCambioCita(this.citas.get(hora), this.citas.size());
                Cita cp = this.citas.get(hora);
                this.citas.set( hora, new Cita(ip, puerto, documento, prioritaria ) );
                this.citas.add(cp);
            }
        }
        return "se ha cuadrado una cita en " + hora + " horas";
    }

    void EnviarMensajeCambioCita(Cita c, int horas) throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry(c.getIp(), c.getPuerto());
        iCliente rmiCliente = (iCliente) registry.lookup("cliente");

        rmiCliente.informacionCita("Se ha cambiado su cita dentro de " + horas + " horas");
    }

    // asignar una cita durante la semana
    // si el peso es superior a 70 alguna fecha, si es mayor a 90, es cita prioritaria
    // si es menor a 70 no es asigna cita
    String evaluarPeso(int peso, String documento, int edad, String ip, int puerto) throws RemoteException, NotBoundException
    {
        String retorno = "no se a cuadrado cita, al no tener sintomas suficientemente riezgosos ";
        if( 70 <= peso )
        {
            retorno = agregarCita( 90<=peso , documento, ip, puerto);
        }
        return "Paciente de documento "+ documento + " tiene "+ edad + " años: " + retorno + "\n";
    }

    @Override
    public boolean nuevaEPS(String nombre, String ip, String puerto) throws RemoteException {
        // TODO Auto-generated method stub
        String direccion[] = new String[2];
        direccion[0] = ip;
        direccion[1] = puerto;
        epses.put(nombre, direccion);
        System.out.println("->" + nombre + "->" + ip);
        return true;
    }

    public boolean nuevaINS(String ip) throws RemoteException {
        // TODO Auto-generated method stub
        insIP = ip;
        return true;
    }
}
