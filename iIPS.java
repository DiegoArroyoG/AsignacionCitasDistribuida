import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iIPS extends Remote {
  public String asignarCita() throws RemoteException;
}