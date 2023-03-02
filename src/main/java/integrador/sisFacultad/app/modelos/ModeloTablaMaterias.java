package integrador.sisFacultad.app.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaMaterias extends AbstractTableModel
{
    private final ArrayList<Materia> lista= new ArrayList<>();
     
    private final String[] columnNames = new String[] {
            "Id", "Nombre", "Cuatrimestre"
    };
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, Integer.class
    };
 
    public ModeloTablaMaterias(ArrayList<ArrayList<Materia>> materias)
    {
        for(int cuatri=0; cuatri < materias.size();cuatri++){
            for(int materia=0 ; materia < materias.get(cuatri).size();materia++){
                this.lista.add(materias.get(cuatri).get(materia));
                
            }
        }
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return lista.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Materia row = getMateria(rowIndex);
        if(0 == columnIndex) {
            return row.getId();
        }
        else if(1 == columnIndex) {
            return row.getNombre();
        }
        else if(2 == columnIndex) {
            return row.getCuatri();
        }
        return null;
    }
    
    public Materia getMateria(int row){
        return lista.get( row );
    }

}