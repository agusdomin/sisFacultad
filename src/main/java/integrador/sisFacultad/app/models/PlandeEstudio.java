package integrador.sisFacultad.app.models;

import java.util.ArrayList;

public abstract class PlandeEstudio {
    private int id;
    private String nombre;
    private String descripcion;
    private boolean verificarFinales; //La utilizo para el metodo verificarCorrelativas
    private boolean verificarFinalesCorrelativos;
    private int cuatPrevios=0; // La utilizo para el metodo verificarHistoria
    
    public PlandeEstudio(int id,String descripcion,String nombre,boolean verificarFinales, boolean verificarFinalesCorrelativos, int cuatPrevios){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cuatPrevios=cuatPrevios;
        this.verificarFinales=verificarFinales;
        this.verificarFinalesCorrelativos=verificarFinalesCorrelativos;
    }
    
    public String getDescripcion(){return this.descripcion;}
    public int getId(){return this.id;}
    
    public final void verificarCondiciones(Materia materia, Alumno alumno){
        ArrayList<ArrayList<Cursada>> cursadas = alumno.getAllCursadas();
        ArrayList<Materia> correlativas = materia.getAllCorrelativas();
        
        if(verificarCorrelativas(correlativas,cursadas));
        if(this.verificarFinales){ 
            verificarHistoria(materia.getCarrera().getAllMaterias(),cursadas);
        }
    }
    
    public Cursada buscarCursada(Materia materia){
        //Faltaria datos de alumno
        //Verificar si es necesario que la responsabildiad sea del Plan de estudio
        return null;
    }
    
    public boolean verificarCorrelativas( ArrayList<Materia> correlativas,ArrayList<ArrayList<Cursada>> cursadas){
        int i=0;
        boolean cumpleCond=true;
        while((i<correlativas.size())&&(cumpleCond)){
            Cursada cur = buscarCursada(correlativas.get(i));
            
            if(cur!=null){
                if(verificarFinalesCorrelativos){
                    if(!cur.isAprobada()){
                        System.out.println("No puede anotarse porque no aprobo el final");
                        cumpleCond=false;
                    }   
                }else{
                    if(!cur.isRegular()){
                        System.out.println("No puede anotarse porque no regularizo la cursada");
                        cumpleCond=false;
                    }   
                }
            }
            i++;
        }
        
        if(cumpleCond){
            System.out.println("Cumple con los requisitos de las correlativas");
        }
        return cumpleCond;
    };
    
    public boolean verificarHistoria(ArrayList<ArrayList<Materia>> historiaAcademica,ArrayList<ArrayList<Cursada>> cursadas){
        return true;
    };
}
