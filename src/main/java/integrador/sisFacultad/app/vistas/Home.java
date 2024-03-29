package integrador.sisFacultad.app.vistas;

import integrador.sisFacultad.app.vistas.panels.RegistroInscripcionesPanel;
import integrador.sisFacultad.app.vistas.panels.PropuestaCarrerasPanel;
import integrador.sisFacultad.app.vistas.panels.GestionPlanesPanel;
import integrador.sisFacultad.app.Facultad;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends javax.swing.JFrame {
    private Facultad controler;
    private PropuestaCarrerasPanel carrerras;
    private RegistroInscripcionesPanel inscripciones;
    private GestionPlanesPanel planes;
    
    public Home(Facultad controler) {
        initComponents();
        this.controler=controler;
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.carrerras = new PropuestaCarrerasPanel(this.controler,this);
        this.inscripciones = new RegistroInscripcionesPanel(this.controler,this);
        this.planes = new GestionPlanesPanel(this.controler,this);

        //Comienzo de los logs
        this.controler.logInfo("Se da inicio al sistema de la facultad");
        this.cargarTextArea();
        
        contenedor.removeAll();
        contenedor.add(carrerras, BorderLayout.CENTER);
        contenedor.revalidate(); 
        contenedor.repaint();
        if(carrerras.isVisible()){
            botonCarrerras.setEnabled(false);
        }
    }
    
    public void cargarTextArea(){
        try {
            this.jTextArea1.append("\n"+this.controler.cargarLogs());
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar los logs en el area de texto");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonCarrerras = new javax.swing.JButton();
        botonInscripciones = new javax.swing.JButton();
        botonPlanes = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de gestion de facultad");

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 480));

        botonCarrerras.setText("Gestión de carrerras");
        botonCarrerras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarrerrasActionPerformed(evt);
            }
        });

        botonInscripciones.setText("Registro de inscripciones");
        botonInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInscripcionesActionPerformed(evt);
            }
        });

        botonPlanes.setText("Gestion de planes de estudio");
        botonPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPlanesActionPerformed(evt);
            }
        });

        contenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedor.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Cuatrimestres pasados:");

        jLabel3.setText("0");

        jButton1.setText("Avanzar a prox. cuatrimestre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Logs");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonInscripciones, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(botonCarrerras, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(botonPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInscripciones)
                    .addComponent(botonCarrerras)
                    .addComponent(botonPlanes)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1307, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCarrerrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarrerrasActionPerformed

        contenedor.removeAll();
        carrerras.setVisible(true);
        contenedor.add(carrerras, BorderLayout.CENTER);        
        
        if(carrerras.isVisible()){
            botonCarrerras.setEnabled(false);
            botonInscripciones.setEnabled(true);
            botonPlanes.setEnabled(true);
        }
        
        contenedor.revalidate(); 
        contenedor.repaint();
    }//GEN-LAST:event_botonCarrerrasActionPerformed

    private void botonInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInscripcionesActionPerformed
        contenedor.removeAll();
        inscripciones.setVisible(true);
        contenedor.add(inscripciones, BorderLayout.CENTER);
        
        if(inscripciones.isVisible()){
            botonInscripciones.setEnabled(false);
            botonCarrerras.setEnabled(true);
            botonPlanes.setEnabled(true);
        }
        
        contenedor.revalidate(); 
        contenedor.repaint();
    }//GEN-LAST:event_botonInscripcionesActionPerformed

    private void botonPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPlanesActionPerformed
        contenedor.removeAll();
        contenedor.add(planes, BorderLayout.CENTER);
        planes.setVisible(true);
        
        if(inscripciones.isVisible()){
            botonInscripciones.setEnabled(true);
            botonCarrerras.setEnabled(true);
            botonPlanes.setEnabled(false);
        }
        
        contenedor.revalidate(); 
        contenedor.repaint();
        
    }//GEN-LAST:event_botonPlanesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x = Integer.parseInt(jLabel3.getText());
        x++;
        jLabel3.setText(Integer.toString(x));
        this.controler.cargarNotas();
        this.controler.logInfo("Se rindieron exámenes");
        this.cargarTextArea();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCarrerras;
    private javax.swing.JButton botonInscripciones;
    private javax.swing.JButton botonPlanes;
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
