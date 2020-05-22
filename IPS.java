import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

public class IPS implements iIPS {
    String insIP;
    HashMap<String, String> epses = new HashMap<String, String>();
    HashMap<String, Integer> clientes = new HashMap<String, Integer>();

    @Override
    public String asignarCita(String ip, String documento, String eps, String fiebre, String tos, String cansancio, String dolor,
            String difRespirar, String insPulmonar, String shockSeptico, String fallaOrganica, String patologia, String cirugia)
            throws RemoteException, NotBoundException {
        System.out.println(epses.get(eps));    
        Registry registry = LocateRegistry.getRegistry(epses.get(eps), 49153);
        iEPS rmiEps = (iEPS) registry.lookup("eps");
        int edad = Integer.parseInt(rmiEps.verificarExistencia(documento));
        int peso;
        if(edad!=-1){
            registry = LocateRegistry.getRegistry(insIP, 49152);
            iINS rmiIns = (iINS) registry.lookup("ins");
            peso = rmiIns.evaluarPaciente(edad, fiebre.equalsIgnoreCase("si"), tos.equalsIgnoreCase("si"), cansancio.equalsIgnoreCase("si"), dolor.equalsIgnoreCase("si"), difRespirar.equalsIgnoreCase("si"), insPulmonar.equalsIgnoreCase("si"), shockSeptico.equalsIgnoreCase("si"), fallaOrganica.equalsIgnoreCase("si"), patologia.equalsIgnoreCase("si"), cirugia.equalsIgnoreCase("si"));
            return "Paciente de documento "+ documento + " tiene "+ edad + " años\n";
        }
        return "Paciente no encontrado en dicha EPS";
    }

    @Override
    public boolean nuevaEPS(String nombre, String ip) throws RemoteException {
        // TODO Auto-generated method stub
        epses.put(nombre, ip);
        System.out.println("->" + nombre + "->" + ip);
        return true;
    }
    
    public boolean nuevaINS(String ip) throws RemoteException {
        // TODO Auto-generated method stub
        insIP = ip;
        return true;
    }
}