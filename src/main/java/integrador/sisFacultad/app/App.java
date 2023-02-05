package integrador.sisFacultad.app;

import integrador.sisFacultad.app.vistas.Home;
import javax.swing.JFrame;
import java.awt.*;

public class App 
{
    public static void main( String[] args )
    {
        final Facultad facu=new Facultad();
        final Home home=new Home(facu);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                home.setVisible(true);
            }
        });
    }
}
