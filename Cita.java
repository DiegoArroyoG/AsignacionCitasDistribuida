

class Cita{
    private String ip;
    private int puerto;
    private String documento;
    private boolean prioritaria;

    Cita(String ip, int puerto, String documento, boolean prioritaria){
        this.ip = ip;
        this.puerto = puerto;
        this.documento = documento;
    }

    public String getDocumento() {
		return documento;
	}

	public int getPuerto() {
		return puerto;
	}

	public boolean esPrioritaria()
    {
        return this.prioritaria;
    }

    public String getIp()
    {
        return this.ip;
    }
}
