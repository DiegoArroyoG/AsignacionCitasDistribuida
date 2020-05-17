import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class INS implements iINS {

    public INS(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(args[1], 49154);
        iIPS epsNueva = (iIPS) registry.lookup("ips");
        epsNueva.nuevaINS(args[2]);
    }

    @Override
    public int evaluarPaciente(int edad, boolean fiebre,boolean tos,boolean cansancio,boolean dolor,boolean difRespirar, 
    boolean insPulmonar, boolean shockSeptico, boolean fallaOrganica, boolean patologia, boolean cirugia) throws RemoteException {
        // TODO Auto-generated method stub
        int peso = 0;
        if((fiebre && tos && cansancio && dolor) && (difRespirar || insPulmonar || shockSeptico || fallaOrganica)){
            peso=60;
        }
        if(edad>70){
            peso+=20;
        }else if(edad>50){
            peso+=10;
        }
        if(patologia){
            peso+=10;
        }
        if(cirugia){
            peso+=10;
        }

        return peso;
    }
    
}