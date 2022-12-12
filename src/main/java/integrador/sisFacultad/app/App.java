package integrador.sisFacultad.app;

import vistas.Home;
import javax.swing.JFrame;
import java.awt.*;

public class App 
{
    public static void main( String[] args )
    {
        final Home home=new Home();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                home.setVisible(true);
            }
        });
    }
}
