package integrador.sisFacultad.app.modelos;

import java.util.ArrayList;

public class Materia {
    
    private int id;
    private String nombre;
    private ArrayList<Materia> correlatividades;
    private Carrera carrera;
    private int cuatrimestre;
        
    public Materia(String nombre,int id,int cuatrimestre,Carrera carrera){   
        this.nombre=nombre;
        this.id=id;
        this.carrera=carrera;
        this.cuatrimestre=cuatrimestre;
        this.correlatividades= new ArrayList<>();
    }

    public void setId(int id){ this.id=id; }
    public int getId(){ return this.id; }
    public void setCuatri(int cuatrimestre){ this.cuatrimestre=cuatrimestre; }
    public int getCuatri(){ return this.cuatrimestre; }
    
    public Carrera getCarrera(){ return this.carrera; }

    public void setNombre(String nombre){ this.nombre=nombre; }
    public String getNombre(){ return this.nombre; }
    
    public void addCorrelativa(Materia materia){
        this.correlatividades.add(materia);
    }
    public Materia getMateria(){
        return this;
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
