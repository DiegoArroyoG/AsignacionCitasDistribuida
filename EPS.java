import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Scanner;

public class EPS implements iEPS {
    String nombre;
    HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

    public EPS(String[] args) throws RemoteException, NotBoundException {
        this.nombre = args[0];
        listaEPS();
        Registry registry = LocateRegistry.getRegistry(args[1], Configuracion.IPS );
        iIPS epsNueva = (iIPS) registry.lookup("ips");
        epsNueva.nuevaEPS(this.nombre, args[2], args[3]);
    }

    public void listaEPS() {
        String[] line;

        try {
            Scanner input = new Scanner(new File("listaUsuarios.txt"));
            while (input.hasNextLine()) {
                line = input.nextLine().split(",");
                if(line[0].equalsIgnoreCase(this.nombre)){
                    Usuario u1 = new Usuario(line[1].trim(), line[3].trim());
                    this.usuarios.put(line[2].trim(), u1);
                }
            }
        } catch (Exception e){
            System.out.println("Mal");
        }
    }

    @Override
    public String verificarExistencia(String documento) throws RemoteException {
        if(this.usuarios.containsKey(documento)){
            System.out.println("Funciono!");
            return this.usuarios.get(documento).getEdad();
        }
        return "-1";
    }
}
