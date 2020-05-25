import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class sINS {
    public static void main(String[] args) {
        if(args.length>1){
            try {
                Registry registry = LocateRegistry.createRegistry(Configuracion.INS);

                INS ins = new INS(args);
                iINS rmiINS = (iINS) UnicastRemoteObject.exportObject(ins, 0);
                registry = LocateRegistry.getRegistry(49152);
                registry.bind("ins", rmiINS);

            } catch (Exception e) {
                System.out.println("---" + e.getMessage());
            }
        }
    }
}
