package integrador.sisFacultad.app.models;

public class Cursada {
    private Materia materia;
    private int notaParcial;
    private int notaFinal;
    
    public Cursada( int notaParcial,int notaFinal){
        this.notaFinal=notaFinal;
        this.notaParcial=notaParcial;
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

}