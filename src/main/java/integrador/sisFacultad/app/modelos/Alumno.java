package integrador.sisFacultad.app.modelos;

import java.util.ArrayList;


/*
        Se entiende por "Inscripto" a aquella persona que no esta inscripta 
        a una carrera, pero si esta inscripta a la facultad.
        Y por alumno a aquel inscripto a una carrera.
*/

public class Alumno{
    
    private int documento;
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<ArrayList<Cursada>> cursadas;// --> coleccion: misma que coleccion de materias (Carrera)
    private Carrera carrera;
    /* recorrer coleccion ejemplo
        for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.get(i).size(); j++) {
                System.out.print(aList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    */
    public Alumno(int doc,String nombre,String apellido,int edad,Carrera carrera){
        this.documento=doc;
        this.nombre=nombre;
        this.apellido=apellido;
        this.carrera=carrera;
    }
    public Alumno(int doc,String nombre,int edad,String apellido){
        this.documento=doc;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public int getDocumento(){
        return this.documento;
    }
    public void setDocumento(int doc){
        this.documento=doc;
    }
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public Carrera getCarrera(){
        return this.carrera;
    }
    public void setCarrera(Carrera carrera){
        this.carrera=carrera;
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    // Parte de gestion de cursadas
/*    public boolean isCursando(Materia materia){
    
        for (int cursada = 0; cursada < cursadas.get(materia.getCuatrimestre()).size(); cursada++) {
            if(cursadas.get(materia.getCuatrimestre()).get(cursada).getMateria()==materia){
                return true;
            }
        }
        return false;
    }
*/  
    public Cursada getCursada(Materia materia){
        // Verificar la cursada que corresponde a la materia
        // Iterar cursadas.get(materia.getCuatrimestre())
        // Para buscar si alguna cursada corresponde con la materia
        
        for (int cursada = 0; cursada < cursadas.get(materia.getCuatri()).size(); cursada++) {
             if(cursadas.get(materia.getCuatri()).get(cursada).getMateria()==materia){
                 return cursadas.get(materia.getCuatri()).get(cursada);
             }
         }
        
        System.out.println("El alumno no esta cursando esta materia");
        return null;
    }
    
    public void cursarMateria(Materia materia){    
        if((getCursada(materia)==null)){
          // Se agrega una nueva cursada a la materia requerida
          Cursada cursada = new Cursada(materia);
          //Agrego la cursada a la historia del alumno al cuatri requerido
          this.cursadas.get(materia.getCuatri()).add(cursada);
        }
        System.out.println("El alumno ya estaba cursando esta materia");
    }
    
    public void abandonarCursada(Materia materia){
        int x=materia.getCuatri();    
        Cursada cursada = getCursada(materia);
        if(cursada!=null){
            this.cursadas.get(x).remove(cursada);
        }
    }

    public ArrayList<ArrayList<Cursada>> getAllCursadas(){
        return this.cursadas;
    }
    
}