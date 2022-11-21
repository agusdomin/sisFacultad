package integrador.sisFacultad.app.models;

import java.util.ArrayList;

public class Materia {
    private int id;
    private String nombre;
    private ArrayList<Materia> correlatividades;
    private Carrera carrera;
    
    
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
    public Carrera getCarrera(){
        return this.carrera;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void addCorrelativa(Materia materia){
        this.correlatividades.add(materia);
    }
    public ArrayList<Materia> getAllCorrelativas(){
        return this.correlatividades;
    }
    public boolean isCorrelativa(Materia materia){
        if(this.correlatividades.contains(materia)){
            return true;
        }else{
            return false;
        }   
    }
    public Materia getCorrelativa(int id){
        for(int i=0;i<correlatividades.size();i++){
            if(correlatividades.get(i).getId()==id){
                return correlatividades.get(i);
            }
        }
        return null;
    
    }
}
