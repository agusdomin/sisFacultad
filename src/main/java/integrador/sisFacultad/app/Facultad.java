package integrador.sisFacultad.app;

import integrador.sisFacultad.app.exepciones.inscriptoRegistradoException;
import integrador.sisFacultad.app.modelos.Alumno;
import integrador.sisFacultad.app.modelos.Carrera;
import integrador.sisFacultad.app.modelos.Materia;
import integrador.sisFacultad.app.modelos.PlandeEstudio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Facultad {
    private File logs = new File("logs.txt");
    
    /* "Inscriptos" refiere a personas inscriptas a la facultad pero no a carreras. */
    private ArrayList<Alumno> inscriptos = new ArrayList<>(); 
    /* Inscriptos refiere a los inscriptos que cursan una carrera */
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<PlandeEstudio> planes = new ArrayList<>();
    private ArrayList<Carrera> carreras = new ArrayList<>();
    
    public Facultad(){
        PlandeEstudio plan1 = new PlandeEstudio(1,"A",false,0,false);
        PlandeEstudio plan2 = new PlandeEstudio(2,"B",false,0,false);
        PlandeEstudio plan3 = new PlandeEstudio(3,"C",true,0,false);
        PlandeEstudio plan4 = new PlandeEstudio(4,"D",false,5,false);
        this.planes.add(plan1);
        
        this.planes.add(plan2);
        this.planes.add(plan3);
        this.planes.add(plan4);
        Carrera car1 = new Carrera(1,"Sistemas","es de grado",plan1,10,0);
        Carrera car2 = new Carrera(2,"analista","es de pre grado",plan1,10,0);
        Carrera car3 = new Carrera(3,"contador","es de grado",plan1,10,0);
        
        
        Materia mat1 = new Materia("Programacion 1",1,1,car1);
        Materia mat2 = new Materia("Programacion 2",2,1,car1);
        Materia mat3 = new Materia("Programacion 3",3,2,car1);
        Materia mat4 = new Materia("Programacion 4",4,2,car1);
        car1.addMateria(mat1, mat1.getCuatri());
        car1.addMateria(mat2, mat2.getCuatri());
        car1.addMateria(mat3, mat3.getCuatri());
        car1.addMateria(mat4, mat4.getCuatri());
        
        this.carreras.add(car1);    
        this.carreras.add(car2); 
        this.carreras.add(car3); 
        
        Alumno alu1 = new Alumno(111,"agustin","dominguez",24,car1);
        Alumno alu3 = new Alumno(333,"agustin","dominguez",24,car2);
        Alumno alu2 = new Alumno(222,"Sebastian","rodriguez",22);
        
        alu1.cursarMateria(mat1);
        alu1.cursarMateria(mat2);
        alu1.cursarMateria(mat3);
        
        this.alumnos.add(alu1);
        this.alumnos.add(alu3);
        this.inscriptos.add(alu2);
        
        
        try{
            if(!this.logs.exists()){    
                this.logs.createNewFile();
                System.out.println("Se crea el archivo de logs");
                this.logInfo("Se crea el archivo de logs");
            }else{
                System.out.println("El archivo de logs ya existe");   
            }
        }catch(IOException e){
            System.out.println("Hubo un error al manipular el archivo de logs");
        }
        
        
    }
    
    
     public void logInfo(String info){
        try{ 
            //Formateo la fecha y tiempo
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            FileWriter writer = new FileWriter(this.logs.getName(),true);
            writer.write("\n"+now.format(formatoFecha)+"-"+info);
            writer.close();
            System.out.println("Se escribió existosamente en el archivo");
            System.out.println("Texto: "+info);
        }catch(IOException e){
            System.out.println("Ocurrió un error al querer escribir en el archivo");
            e.printStackTrace();
        }   
    }
     
    private String ultima_linea;
    public String cargarLogs() throws IOException{
        
        BufferedReader input = new BufferedReader(new FileReader(this.logs.getName()));
        String linea;

        while ((linea = input.readLine()) != null) { 
            ultima_linea = linea;
        }
        
        return ultima_linea;
    }
    
    public void cargarNotas(){
        this.alumnos.forEach((alumno)->{
            alumno.rendirExamenes();
        });
    }
    private int getNewIDcarrera(){
        int id = carreras.size()+1;
        return id;
    }
    
    
    public void modificarPlan(PlandeEstudio viejo_plan,String letra, boolean verificarFinalesCorrelativos, int cuatPrevios,boolean verificarFinales){
        viejo_plan.setLetra(letra);
        viejo_plan.setVerificarFinalesCorrelativos(verificarFinalesCorrelativos);
        viejo_plan.setCuatPrevios(cuatPrevios);
        viejo_plan.setVerificarFinalesCuatPrevios(verificarFinales);
        viejo_plan.setDescripcion();
    }
    public void modificarInscripto(Alumno inscripto,String nombre, String apellido, int doc, int edad){
        inscripto.setNombre(nombre);
        inscripto.setApellido(apellido);
        inscripto.setDocumento(doc);
        inscripto.setEdad(edad);
    }
    
    
    public void modificarCarrera(Carrera vieja, String nombre, String descripcion, PlandeEstudio plan,int cant_cuatri, int optativas){
        vieja.setDescripcion(descripcion);
        vieja.setNombre(nombre);
        vieja.setOptativas(optativas);
        vieja.setPlan(plan);
        vieja.setCantCuatri(cant_cuatri);
    }
    
    public void modificarMateria(Materia vieja, String nombre, int id,int cuatri){
        vieja.setNombre(nombre);
        vieja.setCuatri(cuatri);
        vieja.setId(id);
    }
    
    // Parte de gestion de inscriptos
    public boolean inscribirPersona(int doc, String nombre, String apellido,int edad){
        Alumno persona = new Alumno(doc,nombre,apellido,edad);
        try{
            for (int i = 0; i < inscriptos.size(); i++) {
                if(inscriptos.get(i).getDocumento()==persona.getDocumento()){
                        System.out.println("El alumno ya esta inscripto a esta carrera");   
                        throw new inscriptoRegistradoException("El alumno ya esta inscripto a esta carrera");
                }
            }        
        }catch(inscriptoRegistradoException e){
            return false;
        }
        this.inscriptos.add(persona);
        return true;
        
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
    public void addPlan(String letra, boolean verificarFinalesCorrelativos, int cuatPrevios,boolean verificarFinales){
        PlandeEstudio plan = new PlandeEstudio(letra,verificarFinalesCorrelativos,cuatPrevios,verificarFinales);
        this.planes.add(plan);
    }
    public void borrarPlan(int id){}
    public void borrarPlan(PlandeEstudio plan){}

    public ArrayList<PlandeEstudio> getAllPlanes(){
        return this.planes;
    }
    // Parte de gestion de carreras
    public void addCarrera(String nombre,String descripcion,PlandeEstudio plan,int cant_cuatri,int optativas){
        Carrera carrera = new Carrera(getNewIDcarrera(),nombre,descripcion,plan,cant_cuatri,optativas);
        this.carreras.add(carrera);
        System.out.println(carreras.toString());
    }
    public PlandeEstudio getPlan(PlandeEstudio plan){
        int a = planes.indexOf(plan);
        if(a>-1){
            System.out.println("Se encontró la carrera en el array, indice: "+a);
            return planes.get(a);
        }else{
            System.out.println("No se encontró la carrera en el array, el indice es cualquiera");
            return null;    
        }
    }
    public Carrera getCarrera(Carrera carrera){
        int a = carreras.indexOf(carrera);
        if(a>-1){
            System.out.println("Se encontró la carrera en el array, indice: "+a);
            return carreras.get(a);
        }else{
            System.out.println("No se encontró la carrera en el array, el indice es cualquiera");
            return null;    
        }
        
  //      this.carreras.forEach((car) -> {
//            System.out.println(car.toString());
        //});
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
    public void inscribirAlumnoaCarrera(Alumno inscripto, Carrera carrera){
        
        inscripto.setCarrera(this.getCarrera(carrera));
        inscripto.setFechaCursada();
        if(!this.alumnos.contains(inscripto)){
            this.alumnos.add(inscripto);
            this.inscriptos.remove(inscripto);
            System.out.println("Se inscribio a la persona a la carrera "+carrera.getNombre());
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
    

        
    public Alumno getInscripto(Alumno inscripto){
        int a = inscriptos.indexOf(inscripto);
        if(a>-1){
            System.out.println("Se encontró a el inscripto en el array, indice: "+a);
            return inscriptos.get(a);
        }else{
            System.out.println("No se encontró a el inscripto en el array, el indice es cualquiera");
            return null;    
        }
        
    }
    public Alumno getAlumno(Alumno alumno){
        int a = alumnos.indexOf(alumno);
        if(a>-1){
            System.out.println("Se encontró a el alumno en el array, indice: "+a);
            return alumnos.get(a);
        }else{
            System.out.println("No se encontró a el inscripto en el array, el indice es cualquiera");
            return null;    
        }
    }
}
