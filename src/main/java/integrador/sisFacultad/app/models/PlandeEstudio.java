package integrador.sisFacultad.app.models;

import java.util.ArrayList;

public abstract class PlandeEstudio {
    private int id;
    private String descripcion;
    private boolean verficarFinales; //La utilizo para el metodo verificarCorrelativas
    private int cuatPrevios; // La utilizo para el metodo verificarHistoria
    
    public PlandeEstudio(int id,String descripcion,boolean verficarFinales, int cuatPrevios){
        this.id=id;
        this.descripcion=descripcion;
        this.cuatPrevios=cuatPrevios;
        this.verficarFinales=verficarFinales;
    }
    
    public String getDescripcion(){return this.descripcion;}
    public int getId(){return this.id;}
    
    public final void verificarCondiciones(Materia materia, Alumno alumno){
        ArrayList<ArrayList<Materia>> cursadas = alumno.getAllCursadas();
        ArrayList<Materia> correlativas = materia.getAllCorrelativas();
        
        verificarCorrelativas(correlativas,cursadas);
        if(necesitaVerificarHistoria()){ 
            verificarHistoria(materia.getCarrera().getAllMaterias());
        }
    }
    
    public boolean verificarCorrelativas( ArrayList<Materia> correlativas,ArrayList<ArrayList<Materia>> cursadas){
        
        for (int i = 0; i < correlativas.size(); i++){
            int k = correlativas.get(i).ge
            cursadas.get(correlativas.get(i)).contains
            if(!(cursadas.get(correlativas.get(id)).contains(correlativas[i]))){
              System.out.println("La materia "++"no fue aprobada por el alumno")                ;
            }
            return false;
        }
        
        return true;
        
    };
    public boolean verificarHistoria(ArrayList<ArrayList<Materia>> historiaAcademica){
        
    };
    public boolean necesitaVerificarHistoria(){ //hook -
        return cuatPrevios != 0; //Si es igual a 0, no es necesario verificar la historia previa que no sean correlativas
    };
    
}
