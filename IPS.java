import java.rmi.RemoteException;
import java.util.HashMap;

public class IPS implements iIPS {
    HashMap<String, Integer> clientes = new HashMap<String, Integer>();

    @Override
    public String asignarCita(String documento, String fiebre, String tos, String cansancio, String dolor,
            String difRespirar, String insPulmonar, String shockSeptico, String fallaOrganica) throws RemoteException {
        // TODO Auto-generated method stub
        
        return null;
    }
    
}