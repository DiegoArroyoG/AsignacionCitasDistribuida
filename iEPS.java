import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iEPS extends Remote {
  public boolean verificarExistencia() throws RemoteException;
}