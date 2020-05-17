

public class Usuario {
    private String nombre;
    private String edad;

    public Usuario(String nombre, String edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getEdad(){
        return this.edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(String edad){
        this.edad = edad;
    }
}
