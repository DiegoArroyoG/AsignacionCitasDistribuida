import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class sIPS {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(Configuracion.IPS);

            IPS ips = new IPS();
            iIPS rmiIPS = (iIPS) UnicastRemoteObject.exportObject(ips, 0);
            registry = LocateRegistry.getRegistry(Configuracion.IPS);
            registry.bind("ips", rmiIPS);
        } catch (Exception e) {
            System.out.println("---" + e.getMessage());
        }
    }
}
