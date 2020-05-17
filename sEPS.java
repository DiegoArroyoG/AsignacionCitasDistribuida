import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class sEPS {
    public static void main(String[] args) {
        if(args.length>3){
            try {
                Registry registry = LocateRegistry.createRegistry(49153);

                EPS eps = new EPS(args[0]);
                iEPS rmiEPS = (iEPS) UnicastRemoteObject.exportObject(eps, 0);
                registry = LocateRegistry.getRegistry(49153);
                registry.bind("eps", rmiEPS);

            } catch (Exception e) {
                System.out.println("---" + e.getMessage());
            }
        }
    }
}