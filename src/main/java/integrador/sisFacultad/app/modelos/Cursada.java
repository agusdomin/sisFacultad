package integrador.sisFacultad.app.modelos;

import java.util.Random;

public class Cursada {
    private Materia materia;
    private int notaParcial=0;
    private int notaFinal=0;
    
    public Cursada(Materia materia){
        this.materia=materia;
    }
    
    public Cursada(Materia materia, int notaParcial,int notaFinal){
        this.materia=materia;
        this.notaFinal=notaFinal;
        this.notaParcial=notaParcial;
    }
    
    public void rendirExamen(){
        Random rand = new Random();
        int nota_max=10;
        if(!isRegular()){
            int nota_parcial = rand.nextInt(nota_max)+1; 
            this.setParcial(nota_parcial);
            if(isRegular()){
                int nota_final = rand.nextInt(nota_max)+1;
                this.setFinal(nota_final);
            }else{
                this.setFinal(0);
            }    
        }else{
            if(!isAprobada()){
                int nota_final = rand.nextInt(nota_max)+1;
                this.setFinal(nota_final);
            }
        }
        
        
    }
    public int getCuatrimestre(){
        return this.materia.getCuatri();
    }
    public Materia getMateria(){
        return this.materia;
    }
    public int getIdMateria(){
        return this.materia.getId();
    }
    public void setParcial(int notaParcial){
        this.notaParcial=notaParcial;
    }
    public int getParcial(){
        return this.notaParcial;
    }
    public void setFinal(int notaFinal){
        this.notaFinal=notaFinal;
    }
    public int getFinal(){
        return this.notaFinal;
    }
    public boolean isRegular(){
        if(this.notaParcial>=4){
            return true;
        }else{
            return false;
        }
    }
    public boolean isAprobada(){
        if(isRegular()){
            if(this.notaFinal>=4){
                return true;
            }else{
                return false;
            }    
        }
        return false;
    }
}