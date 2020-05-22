

class Cita{
    private String ip;
    private String documento;
    private boolean prioritaria;

    Cita(String ip, String documento, boolean prioritaria){
        this.ip = ip;
        this.documento = documento;
    }

    boolean esPrioritaria()
    {
        return this.prioritaria;
    }
}


