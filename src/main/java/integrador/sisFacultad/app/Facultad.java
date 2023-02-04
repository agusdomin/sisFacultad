package integrador.sisFacultad.app;

import java.util.ArrayList;

import integrador.sisFacultad.app.models.*;

public class Facultad {
    /* "Inscriptos" refiere a personas inscriptas a la facultad pero no a carreras. */
    private ArrayList<Alumno> inscriptos; 
    /* Inscriptos refiere a los inscriptos que cursan una carrera */
    private ArrayList<Alumno> alumnos;
    private ArrayList<PlandeEstudio> planes = new ArrayList<PlandeEstudio>();;
    private ArrayList<Carrera> carreras = new ArrayList<Carrera>();
    
    public Facultad(){
        PlandeEstudio plan1 = new PlandeEstudio(1,"Sin verificar finales, ni vorrelativos, ni cuatri previos","PlanA",false,false,0);
        PlandeEstudio plan2 = new PlandeEstudio(2,"Sin verificar finales","PlanB",false,false,0);
        this.planes.add(plan1);
        this.planes.add(plan2);
        Carrera car1 = new Carrera(1,"Sistemas","es de grado",plan1,0);
        Carrera car2 = new Carrera(2,"analista","es de pre grado",plan1,0);
        Carrera car3 = new Carrera(3,"contador","es de grado",plan1,0);
        this.carreras.add(car1);    
        this.carreras.add(car2); 
        this.carreras.add(car3); 
    }
    
    public int getNewIDcarrera(){
        int id = carreras.size()+1;
        return id;
    }
    
    public void modificarCarrera(Carrera vieja,Carrera nueva){
        int a = carreras.indexOf(vieja);
        carreras.set(a, nueva);
        System.out.println(carreras.toString());
    }
    
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
        System.out.println(carreras.toString());
    }
    public Carrera getCarrera(Carrera carrera){
        int a = carreras.indexOf(carrera);
        System.out.println(a);
        return carreras.get(a);
        //carreras.forEach((car)->{
        //    if(car.getId()==carrera.getId()){
        //        return car; }  });
        
    }
    
    public void borrarCarrera(int id){}
    public void borrarCarrera(Carrera carrera){}
    
    public ArrayList<Carrera> getAllCarreras(){
        return this.carreras;
    }
    
    // Parte de gestion de alumnos
    public void inscribirAlumno(Alumno alumno){
        if(!alumnos.contains(alumno)){
            this.alumnos.add(alumno);
        }else{
            System.out.println("El alumno ya esta inscripto a esta carrera");
        }
    }
    public void borrarAlumno(Alumno alumno){
        if(alumnos.contains(alumno)){
            this.alumnos.remove(alumno);
        }else{
            System.out.println("El alumno no esta inscripto a esta carrera");
        }
    }
    public ArrayList<Alumno> getAllAlumno(){
        return this.alumnos;
    }
    public Alumno getAlumno(int doc){
        for(int i=0;i<alumnos.size();i++){
            if(this.alumnos.get(i).getDocumento()==doc){
                return alumnos.get(i);       
            }
        }
        return null;
    }
}
