import java.rmi.RemoteException;
import java.util.HashMap;

public class IPS implements iIPS {
    String insIP;
    HashMap<String, String> epses = new HashMap<String, String>();
    HashMap<String, Integer> clientes = new HashMap<String, Integer>();

    @Override
    public String asignarCita(String documento, String fiebre, String tos, String cansancio, String dolor,
            String difRespirar, String insPulmonar, String shockSeptico, String fallaOrganica) throws RemoteException {
        // TODO Auto-generated method stub
        
        return null;
    }

    @Override
    public boolean nuevaEPS(String nombre, String ip) throws RemoteException {
        // TODO Auto-generated method stub
        epses.put(nombre, ip);
        return true;
    }
    
    public boolean nuevaINS(String ip) throws RemoteException {
        // TODO Auto-generated method stub
        insIP = ip;
        return true;
    }
}