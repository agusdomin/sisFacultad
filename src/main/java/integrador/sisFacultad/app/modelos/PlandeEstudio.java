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
    public void setLetra(String letra){this.letra=letra;}
    public String getLetra(){return this.letra;}
    public void setVerificarFinalesCorrelativos(boolean value){this.verificarFinalesCorrelativos=value;}
    public void setVerificarFinalesCuatPrevios(boolean value){this.verificarFinales=value;}
    public void setCuatPrevios(int n){this.cuatPrevios=n;}
    public boolean getVerificarFinalesCorrelativos(){return this.verificarFinalesCorrelativos;}
    public boolean getVerificarFinalesCuatPrevios(){return this.verificarFinales;}
    public int getCuatPrevios(){return this.cuatPrevios;}
    
    public Cursada buscarCursada(Materia materia,ArrayList<ArrayList<Cursada>> cursadas){
        for (int cuatri = 0; cuatri < cursadas.size(); cuatri++) {
            for (int cursada = 0; cursada < cursadas.get(cuatri).size(); cursada++){
                if(cursadas.get(cuatri).get(cursada).getMateria()==materia){
                    return cursadas.get(cuatri).get(cursada);
                }  
            }           
        }
        return null;
    }
    
    public boolean verificarCorrelativas( ArrayList<Materia> correlativas,ArrayList<ArrayList<Cursada>> cursadas){
        int i=0;
        
        while((i<correlativas.size())){
            Cursada cur = buscarCursada(correlativas.get(i),cursadas);
            
            if(cur!=null){
                if(verificarFinalesCorrelativos){
                    if(!cur.isAprobada()){
                        System.out.println("No puede anotarse porque no aprobo el final de "+cur.getMateria().getNombre());
                        return false;
                    }   
                }else{
                    if(!cur.isRegular()){
                        System.out.println("No puede anotarse porque no regularizo la cursada de la materia "+cur.getMateria().getNombre());
                        return false;
                    }   
                }
            }else{
                System.out.println("No puede anotarse porque no curso la materia "+correlativas.get(i).getNombre());
                return false;
            }
            i++;
        }
        System.out.println("Cumple con los requisitos de las correlativas");
        return true;
    };
    
    public boolean verificarHistoria(int cuatriActual, ArrayList<ArrayList<Materia>> materias,ArrayList<ArrayList<Cursada>> historiaAcademica){
        
        //Por cada materia de los cuatrimestres correspondientes.
        for( int cuatri=cuatriActual-1; cuatri>=(cuatriActual-this.cuatPrevios) ;cuatri-- ){
            for (int materia = 0; materia < materias.get(cuatri).size(); materia++){
                //verificar si se cursó y si se aprobó el final la materia
                Cursada cur = buscarCursada(materias.get(cuatri).get(materia),historiaAcademica);
                if(!cur.isAprobada()){
                    System.out.println("No puede anotarse porque no aprobo el final de "+cur.getMateria().getNombre()+" del cuatrimestre n° "+cuatri);
                    return false;
                }else{
                    System.out.println("El final de "+cur.getMateria().getNombre()+" del cuatrimestre n° "+cuatri+" esta aprobado");
                }   
            }
        }
        return true;
    };
    
    public boolean verificarGraduacion(ArrayList<ArrayList<Materia>> materias,ArrayList<ArrayList<Cursada>> historiaAcademica){
        for( int cuatri=0; cuatri<materias.size() ;cuatri++ ){
            for (int materia = 0; materia < materias.get(cuatri).size(); materia++){
                //verificar si se cursó y si se aprobó el final la materia
                Cursada cur = buscarCursada(materias.get(cuatri).get(materia),historiaAcademica);
                if(cur!=null){
                    if(!cur.isAprobada()){
                        System.out.println("No puede graduarse porque no aprobo el final de "+cur.getMateria().getNombre()+" del cuatrimestre n° "+cuatri);
                        return false;
                    }else{
                        System.out.println("El final de "+cur.getMateria().getNombre()+" del cuatrimestre n° "+cuatri+" esta aprobado");
                    }       
                }else{
                    System.out.println("No puede graduarse porque no curso la materia "+materias.get(cuatri).get(materia).getNombre()+" del cuatrimestre n° "+materias.get(cuatri).get(materia).getCuatri());
                    return false;
                }
                
            }
        }
        return true;
    }
    
    public final boolean verificarCondiciones(Materia materia, Alumno alumno){
        ArrayList<ArrayList<Cursada>> cursadas = alumno.getAllCursadas();
        ArrayList<Materia> correlativas = materia.getAllCorrelativas();
        
        if(!correlativas.isEmpty() ){
            if(! verificarCorrelativas(correlativas,cursadas)){
                return false;
            }
        }
        
        if(this.verificarFinales){ 
            verificarHistoria(materia.getCuatri(),alumno.getCarrera().getAllMaterias(),cursadas);
        }
        return true;
    }
    
}
