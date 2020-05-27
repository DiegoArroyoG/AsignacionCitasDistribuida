import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iIPS extends Remote {
    public String asignarCita(String ip, int puerto, String documento, String eps, String fiebre, String tos, String cansancio, String dolor, String difRespirar, String insPulmonar, String shockSeptico, String fallaOrganica, String patologia, String cirugia) throws RemoteException, NotBoundException;
    public boolean nuevaEPS(String nombre, String ip, String puerto) throws RemoteException;
  public boolean nuevaINS(String ip) throws RemoteException;
}
