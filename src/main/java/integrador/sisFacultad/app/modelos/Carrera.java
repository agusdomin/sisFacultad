package integrador.sisFacultad.app.modelos;

import java.util.ArrayList;

public class Carrera {
    private int id;
    private String nombre;
    private String descripcion;
    private PlandeEstudio plan;
    private int cant_cuatri;
    private int nOptativas;
    private ArrayList<ArrayList<Materia>> materias; //--> coleccion: misma que coleccion de cursadas(Alumno))
    
    public Carrera(int id,String nombre,String descripcion,PlandeEstudio plan,int cant_cuatri,int optativas){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.nOptativas=optativas;
        this.cant_cuatri=cant_cuatri;
        this.plan=plan;
        this.materias=new ArrayList<>();
        initMaterias();
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
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public void setOptativas(int optativas){
        this.nOptativas=optativas;
    }
    public int getOptativas(){
        return this.nOptativas;
    }
    public void setCantCuatri(int cant_cuatri){
        this.cant_cuatri=cant_cuatri;
    }
    public int getCantCuatri(){
        return this.cant_cuatri;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    // Parte de gestion de materias
    
    private void initMaterias(){
        /* Tomo la cantidad de cuatrimestres indicado
        por el tamaño del primer arreglo de dos dimensiones
        */
        for(int cuatri=0;cuatri < this.cant_cuatri ; cuatri++){
            this.materias.add(new ArrayList<Materia>());
        }
    }
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
    
    public Materia getMateria(int id){
        for (int cuatri = 0; cuatri < materias.size(); cuatri++) {
            for (int materia = 0; materia < materias.get(cuatri).size(); materia++){
                if(materias.get(cuatri).get(materia).getId()==id){
                    return materias.get(cuatri).get(materia);
                }  
            }           
        }
        return null;
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
    //public Materia getMateria(){}    
}
