import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class sCliente {
    public static void main(String[] args) {
        if (args.length > 1) {
            try {
                Registry registry = LocateRegistry.getRegistry(args[0], 49154);
                iIPS epsNueva = (iIPS) registry.lookup("ips");

                Scanner teclado = new Scanner(System.in);
                String[] line = new String[12];
                System.out.println("Digite la cedula: ");
                line[0] = teclado.nextLine();
                System.out.println("Digite nombre EPS: ");
                line[1] = teclado.nextLine();
                System.out.println("Digite si tiene FIEBRE: ");
                line[2] = teclado.nextLine();
                System.out.println("Digite si tiene TOS: ");
                line[3] = teclado.nextLine();
                System.out.println("Digite si tiene CANSANCIO: ");
                line[4] = teclado.nextLine();
                System.out.println("Digite si tiene DOLOR: ");
                line[5] = teclado.nextLine();
                System.out.println("Digite si tiene DIFICULTAD PARA RESPIRAR: ");
                line[6] = teclado.nextLine();
                System.out.println("Digite si tiene INSUFICIENCIA PULMONAR: ");
                line[7] = teclado.nextLine();
                System.out.println("Digite si tiene SHOCK SEPTICO: ");
                line[8] = teclado.nextLine();
                System.out.println("Digite si tiene FALLA MULTIORGANICA: ");
                line[9] = teclado.nextLine();
                System.out.println("Digite si tiene PATOLOGIA IMPORTANTE: ");
                line[10] = teclado.nextLine();
                System.out.println("Digite si tiene CIRUGIA RECIENTE: ");
                line[11] = teclado.nextLine();
                teclado.close();

                System.out.println(epsNueva.asignarCita(args[1], line[0].trim(), line[1].trim(), line[2].trim(),
                        line[3].trim(), line[4].trim(), line[5].trim(), line[6].trim(), line[7].trim(), line[8].trim(),
                        line[9].trim(), line[10].trim(), line[11].trim()));

                registry = LocateRegistry.createRegistry(49155);
                Cliente cliente = new Cliente();
                iCliente rmiCliente = (iCliente) UnicastRemoteObject.exportObject(cliente, 0);
                registry = LocateRegistry.getRegistry(49155);
                registry.bind("cliente", rmiCliente);

            } catch (Exception e) {
                System.out.println("---" + e.getMessage());
            }
        }
    }
}