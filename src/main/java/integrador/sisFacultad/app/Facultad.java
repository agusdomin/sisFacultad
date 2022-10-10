package integrador.sisFacultad.app;

import java.util.ArrayList;

import integrador.sisFacultad.app.models.*;

public class Facultad {
    private ArrayList<Alumno> inscriptos;
    private ArrayList<PlandeEstudio> planes;
    private ArrayList<Carrera> carreras;

    public Facultad(){}
    
    // Parte de gestion de inscriptos
    public void inscribirPersona(Alumno alumno){
        if(!inscriptos.contains(alumno)){
            this.inscriptos.add(alumno);
        }else{
            System.out.println("El alumno ya esta inscripto a esta carrera");
        }
    }
    public void borrarInscripto(Alumno alumno){
        if(inscriptos.contains(alumno)){
            this.inscriptos.remove(alumno);
        }else{
            System.out.println("El alumno no esta inscripto a esta carrera");
        }
    }
    public ArrayList<Alumno> getAllInscriptos(){
        return this.inscriptos;
    }
    // Parte de gestion de planes
    public void addPlan(PlandeEstudio plan){
        this.planes.add(plan);
    }
    public void borrarPlan(int id){}
    public void borrarPlan(PlandeEstudio plan){}

    public ArrayList<PlandeEstudio> getAllPlanes(){
        return this.planes;
    }
    // Parte de gestion de carreras
    public void addCarrera(Carrera carrera){
        this.carreras.add(carrera);
    }
    public void borrarCarrera(int id){}
    public void borrarCarrera(Carrera carrera){}
    
    public ArrayList<Carrera> getAllCarreras(){
        return this.carreras;
    }
}
