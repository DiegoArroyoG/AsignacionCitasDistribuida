import java.io.File;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Scanner;

public class EPS implements iEPS {
    String nombre;
    HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

    public EPS(String nombre){
        this.nombre = nombre;
        listaEPS();
    }

    public void listaEPS() {
        String[] line;

        try {
            Scanner input = new Scanner(new File("listaUsuarios.txt"));
            while (input.hasNextLine()) {       
                line = input.nextLine().split(",");
                if(line[0].equalsIgnoreCase(this.nombre)){
                    Usuario u1 = new Usuario(line[1], line[3]);
                    this.usuarios.put(line[2], u1);
                }
            }
        } catch (Exception e){
            System.out.println("Mal");
        }      
    }

    @Override
    public boolean verificarExistencia(String documento) throws RemoteException {
        return this.usuarios.containsKey(documento);
    }    
}