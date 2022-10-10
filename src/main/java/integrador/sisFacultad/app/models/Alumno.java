package integrador.sisFacultad.app.models;

import java.util.ArrayList;

public class Alumno
{
    private int documento;
    private String nombre;
    private String apellido;
    private ArrayList<ArrayList<Materia>> cursadas;// --> coleccion: misma que coleccion de materias (Carrera)
    /* recorrer coleccion ejemplo
        for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.get(i).size(); j++) {
                System.out.print(aList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    */
    public Alumno(int doc,String nombre,String apellido){
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
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    // Parte de gestion de materias
    public boolean isCursando(Materia materia,int cuatrimestre){
        //Verifico que la materia no existe en ningun cuatri
        if(cursadas.get(cuatrimestre).contains(materia)){
            return true;
        }
        return false;
    }
    public int getMateriaCuatrimestre(Materia materia){
        for (int i = 0; i < cursadas.size(); i++) {
            if(cursadas.get(i).contains(materia)){
                return i;
            }           
        }
        return 0;
    }
    public void cursarMateria(Materia materia, int cuatrimestre){    
        if(!(isCursando(materia,cuatrimestre))){
            //Agrego la materia al cuatri requerido
            this.cursadas.get(cuatrimestre).add(materia);
        }
    }
    
    public void abandonarMateria(Materia materia){
        int x=getMateriaCuatrimestre(materia);
        if(x!=0){
            this.cursadas.get(x).remove(materia);
        }
    }

    public ArrayList<ArrayList<Materia>> getAllCursadas(){
        return this.cursadas;
    }
    public void getMateria(){}    
}