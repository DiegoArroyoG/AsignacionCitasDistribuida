import java.rmi.RemoteException;

public class Cliente implements iCliente {

    @Override
    public void informacionCita(String mensaje) throws RemoteException {
        // TODO Auto-generated method stub
        System.out.println("-> " + mensaje);
    }

}