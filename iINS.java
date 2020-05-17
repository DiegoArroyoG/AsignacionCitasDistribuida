import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iINS extends Remote {
  public int evaluarPaciente(int edad, boolean fiebre,boolean tos,boolean cansancio,boolean dolor,boolean difRespirar, boolean insPulmonar, boolean shockSeptico, boolean fallaOrganica, boolean patologia, boolean cirugia) throws RemoteException;
}