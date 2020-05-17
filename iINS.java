import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iINS extends Remote {
  public int calcularPrioridad() throws RemoteException;
}