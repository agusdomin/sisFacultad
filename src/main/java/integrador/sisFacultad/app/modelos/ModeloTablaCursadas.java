package integrador.sisFacultad.app.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaCursadas extends AbstractTableModel
{
    private final ArrayList<Cursada> lista= new ArrayList<>();
     
    private final String[] columnNames = new String[] {
            "Id", "Nombre", "Cuatrimestre", "Parcial", "Final"
    };
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, Integer.class, Integer.class, Integer.class
    };
 
    public ModeloTablaCursadas(ArrayList<ArrayList<Cursada>> cursadas)
    {
         if( cursadas != null){
            for(int cuatri=0; cuatri < cursadas.size();cuatri++){
                for(int materia=0 ; materia < cursadas.get(cuatri).size();materia++){
                    this.lista.add(cursadas.get(cuatri).get(materia));

                }
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
        Cursada cursada = lista.get(rowIndex);
        if(0 == columnIndex) {
            return cursada.getMateria().getId();
        }
        else if(1 == columnIndex) {
            return cursada.getMateria().getNombre();
        }
        else if(2 == columnIndex) {
            return cursada.getMateria().getCuatri();
        }
        else if(3 == columnIndex) {
            return cursada.getParcial();
        }
        else if(4 == columnIndex) {
            return cursada.getFinal();
        }
        
        return cursada;
    }
    
    public Cursada getCursada(int row){
        return lista.get(row);
    }

}