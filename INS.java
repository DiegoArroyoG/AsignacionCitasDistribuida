import java.rmi.RemoteException;

public class INS implements iINS {

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