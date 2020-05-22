import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente implements iCliente {

    @Override
    public void informacionCita(String mensaje) throws RemoteException {
        // TODO Auto-generated method stub
        System.out.println("-> " + mensaje);
    }

}