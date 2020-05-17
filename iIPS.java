import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iIPS extends Remote {
  public String asignarCita(String documento, String fiebre, String tos, String cansancio, String dolor, String difRespirar, String insPulmonar, String shockSeptico, String fallaOrganica) throws RemoteException;
  public boolean nuevaEPS(String nombre, String ip) throws RemoteException;
  public boolean nuevaINS(String ip) throws RemoteException;
}