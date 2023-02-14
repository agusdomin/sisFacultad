package integrador.sisFacultad.app.modelos;

import java.util.ArrayList;

public class PlandeEstudio {
    private int id;
    private String letra;
    private String descripcion;
    
    private boolean verificarFinalesCorrelativos; // si es FALSE, verifica solo cursadas de correlativas
    private int cuatPrevios=0; // La utilizo para el metodo verificarHistoria, si es mayor a 0, revisa cuatris anteriores
    
   private boolean verificarFinales; //La utilizo para el metodo verificarCorrelativas !!REVISAR!!
    
    public PlandeEstudio(int id,String letra, boolean verificarFinalesCorrelativos, int cuatPrevios,boolean verificarFinales){
        this.id=id;
        this.letra=letra;
        this.cuatPrevios=cuatPrevios;
        this.verificarFinales=verificarFinales;
        this.verificarFinalesCorrelativos=verificarFinalesCorrelativos;
        this.descripcion="";
        setDescripcion();
    }
    public PlandeEstudio(String letra, boolean verificarFinalesCorrelativos, int cuatPrevios,boolean verificarFinales){
        this.id=id;
        this.letra=letra;
        this.cuatPrevios=cuatPrevios;
        this.verificarFinales=verificarFinales;
        this.verificarFinalesCorrelativos=verificarFinalesCorrelativos;
        this.descripcion="";
        setDescripcion();
    }
    public String getLetra(){return this.letra;}
    
    public void setDescripcion(){
        this.descripcion="";
        this.descripcion += "Aprobó ";
        if(this.verificarFinalesCorrelativos){
            this.descripcion += "los finales de las correlativas ";
        }else{
            this.descripcion += "las cursadas de las correlativas ";
        }
        
        if(this.cuatPrevios>0){
            this.descripcion += "y los finales de todas las materias de "+this.cuatPrevios+" cuatrimestres previos";
        }
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
    
    public void setLetra(String letra){this.letra=letra;}
    public void setVerificarFinalesCorrelativos(boolean value){this.verificarFinalesCorrelativos=value;}
    public void setVerificarFinalesCuatPrevios(boolean value){this.verificarFinales=value;}
    public void setCuatPrevios(int n){this.cuatPrevios=n;}
    
    public boolean getVerificarFinalesCorrelativos(){return this.verificarFinalesCorrelativos;}
    public boolean getVerificarFinalesCuatPrevios(){return this.verificarFinales;}
    public int getCuatPrevios(){return this.cuatPrevios;}
}
