
package integrador.sisFacultad.app.models;

import java.util.ArrayList;

public class PlanA extends PlandeEstudio {

    public PlanA(int id, String descripcion, boolean verficarFinales, int cuatPrevios) {
        super(id, descripcion, verficarFinales, cuatPrevios);
    }
    
    @Override
    public boolean verificarCorrelativas(Materia materia){
        //verificar si pide finales, sino pide finales, se trata de cursadas solamente
        return true;
    };
    @Override
    public boolean verificarHistoria( ArrayList<ArrayList<Materia>> historiaAcademica){
        // cantidad de cuatrimestres previos
        return true;
    };

}
