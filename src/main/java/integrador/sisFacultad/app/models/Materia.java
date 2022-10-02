package integrador.sisFacultad.app.models;

public class Materia {
    private int id;
    private String nombre;
    private Materia correlatividades;
    
    public Materia(String nombre,int id){   
        this.nombre=nombre;
        this.id=id;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
}
