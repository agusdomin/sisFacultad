package integrador.sisFacultad.app.vistas;

import integrador.sisFacultad.app.Facultad;
import java.awt.BorderLayout;

public class Home extends javax.swing.JFrame {
    private Facultad controler = new Facultad();
    PropuestaCarrerasPanel carrerras = new PropuestaCarrerasPanel(this.controler);
    RegistroInscripcionesPanel inscripciones = new RegistroInscripcionesPanel(this.controler);
    GestionPlanesPanel planes = new GestionPlanesPanel(this.controler);
    
    public Home() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        contenedor.removeAll();
        contenedor.add(carrerras, BorderLayout.CENTER);
        contenedor.revalidate(); 
        contenedor.repaint();
    }
    public Home(Facultad controler) {
        initComponents();
        this.controler= controler;
        setResizable(false);
        this.setLocationRelativeTo(null);
        
        contenedor.removeAll();
        contenedor.add(carrerras, BorderLayout.CENTER);
        contenedor.revalidate(); 
        contenedor.repaint();
        if(carrerras.isVisible()){
            botonCarrerras.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonCarrerras = new javax.swing.JButton();
        botonInscripciones = new javax.swing.JButton();
        botonPlanes = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de gestion de facultad");

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 480));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de gestion de Facultad");

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

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonInscripciones, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonCarrerras, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(botonPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInscripciones)
                    .addComponent(botonCarrerras)
                    .addComponent(botonPlanes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
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
        contenedor.add(inscripciones, BorderLayout.CENTER);
        inscripciones.setVisible(true);
        
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCarrerras;
    private javax.swing.JButton botonInscripciones;
    private javax.swing.JButton botonPlanes;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
