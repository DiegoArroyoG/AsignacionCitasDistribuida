import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iEPS extends Remote {
  public String verificarExistencia(String documento) throws RemoteException;
}