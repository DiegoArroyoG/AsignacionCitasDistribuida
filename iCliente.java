import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iCliente extends Remote {
  public void informacionCita(String mensaje) throws RemoteException;
}