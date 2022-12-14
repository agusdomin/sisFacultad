package integrador.sisFacultad.app.models;

import java.util.ArrayList;

public class Carrera {
    private int id;
    private String nombre;
    private PlandeEstudio plan;
    private int nOptativas;
    private ArrayList<ArrayList<Materia>> materias; //--> coleccion: misma que coleccion de cursadas(Alumno))
    
    public Carrera(int id,String nombre,PlandeEstudio plan, int optativas){
        this.id=id;
        this.nombre=nombre;
        this.nOptativas=optativas;
        this.plan=plan;
    }

    public void setPlan(PlandeEstudio plan){
        this.plan=plan;
    }
    public PlandeEstudio getPlan(){
        return this.plan;
    }
    public int getIdPlan(){
        return this.plan.getId();
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setFinal(String nombre){
        this.nombre=nombre;
    }
    public String getFinal(){
        return this.nombre;
    }
    public void setOptativas(int optativas){
        this.nOptativas=optativas;
    }
    public int getOptativas(){
        return this.nOptativas;
    }
    
    
    // Parte de gestion de materias
    public boolean isMateriaContained(Materia materia){
        //Verifico que la materia no existe en ningun cuatri
        for (int i = 0; i < materias.size(); i++) {
            if(materias.get(i).contains(materia)){
                return true;
            }            
        }
        return false;
    }
    public int getMateriaCuatrimestre(Materia materia){
        for (int i = 0; i < materias.size(); i++) {
            if(materias.get(i).contains(materia)){
                return i;
            }           
        }
        return 0;
    }
    public void addMateria(Materia materia, int cuatrimestre){    
        if(!isMateriaContained(materia)){
            //Agrego la materia al cuatri requerido
            this.materias.get(cuatrimestre).add(materia);
        }
    }
    
    public void borrarMateria(Materia materia){
        this.materias.get(getMateriaCuatrimestre(materia)).remove(materia);
    }

    public ArrayList<ArrayList<Materia>> getAllMaterias(){
        return this.materias;
    }
    public void getMateria(){}    
}
