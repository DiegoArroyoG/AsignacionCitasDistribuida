import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        if(args.length>0){
            try {
                Registry registry = LocateRegistry.getRegistry(args[0], 49154);
                iIPS epsNueva = (iIPS) registry.lookup("ips");
            
                String[] line;
                Scanner input = new Scanner(new File("clientes.txt"));
                while (input.hasNextLine()) {       
                    line = input.nextLine().split(",");
                    System.out.println(epsNueva.asignarCita(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8], line[9], line[10], line[11]));
                }
            } catch (Exception e) {
                System.out.println("---" + e.getMessage());
            }
        }
    }
}