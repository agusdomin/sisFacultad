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
}