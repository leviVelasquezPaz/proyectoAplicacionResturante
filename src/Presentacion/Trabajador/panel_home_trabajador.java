/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Trabajador;

import Presentacionn.frm_principall;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 *
 * @author Levi
 */
public class panel_home_trabajador extends javax.swing.JPanel {

    public static boolean estadoCargo = false;
    public static boolean estadoTurno = false;

    public panel_home_trabajador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        lblAgregar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jPanel2 = new javax.swing.JPanel();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        lblCargo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jXTitledPanel2 = new org.jdesktop.swingx.JXTitledPanel();
        jPanel3 = new javax.swing.JPanel();
        rSLabelImage3 = new rojerusan.RSLabelImage();
        lblTurno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jXTitledPanel3 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        lblAsistencias = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jXTitledPanel4 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 145, 234)));
        jPanel1.setPreferredSize(new java.awt.Dimension(998, 170));

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Cliente/Imagenes/IconoCliente.png"))); // NOI18N

        lblAgregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAgregar.setText("Agregar ");
        lblAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAgregarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAgregarMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Registrar un nuevo cliente ");

        jXTitledPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 145, 234)));
        jPanel2.setPreferredSize(new java.awt.Dimension(682, 170));

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/ImageneTrabajador.png"))); // NOI18N

        lblCargo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCargo.setText("Cargo");
        lblCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCargoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCargoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCargoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCargoMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Agregar un nuevo cargo , actualiza o modificar");

        jXTitledPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(213, 213, 213)
                .addComponent(jXTitledPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(59, 59, 59))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 145, 234)));
        jPanel3.setPreferredSize(new java.awt.Dimension(682, 170));

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/ImageneTrabajador.png"))); // NOI18N

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTurno.setText("Turno");
        lblTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTurnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTurnoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTurnoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblTurnoMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Agregar diferentes turnos que tendran cada uno");

        jXTitledPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234), 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("de tus trabajadores");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(jXTitledPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(326, 326, 326))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rSLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 145, 234)));
        jPanel4.setPreferredSize(new java.awt.Dimension(682, 170));

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/ImageneTrabajador.png"))); // NOI18N

        lblAsistencias.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAsistencias.setText("Asistencias");
        lblAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAsistenciasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAsistenciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAsistenciasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAsistenciasMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Agrege y controle todas las asistencias de sus ");

        jXTitledPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234), 2));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("trabajadores dentro de su corporación");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXTitledPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(326, 326, 326))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblAsistencias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseClicked
        panel_agregar_trabajador a = new panel_agregar_trabajador();
        a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
        frm_principall.panel_principal.removeAll();
        frm_principall.panel_principal.add(a, BorderLayout.CENTER);
        frm_principall.panel_principal.revalidate();
        frm_principall.panel_principal.repaint();
    }//GEN-LAST:event_lblAgregarMouseClicked

    private void lblAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMousePressed
        lblAgregar.setForeground(Color.RED);
    }//GEN-LAST:event_lblAgregarMousePressed

    private void lblCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCargoMouseClicked
        panel_cargo_trabajador a = new panel_cargo_trabajador();
        a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
        frm_principall.panel_principal.removeAll();
        frm_principall.panel_principal.add(a, BorderLayout.CENTER);
        frm_principall.panel_principal.revalidate();
        frm_principall.panel_principal.repaint();
        estadoCargo = true;
    }//GEN-LAST:event_lblCargoMouseClicked

    private void lblCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCargoMousePressed
        lblCargo.setBackground(Color.RED);
    }//GEN-LAST:event_lblCargoMousePressed

    private void lblTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTurnoMouseClicked
        panel_turno_trabajador a = new panel_turno_trabajador();
        a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
        frm_principall.panel_principal.removeAll();
        frm_principall.panel_principal.add(a, BorderLayout.CENTER);
        frm_principall.panel_principal.revalidate();
        frm_principall.panel_principal.repaint();
        estadoTurno = true;
    }//GEN-LAST:event_lblTurnoMouseClicked

    private void lblTurnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTurnoMousePressed
        lblTurno.setBackground(Color.RED);
    }//GEN-LAST:event_lblTurnoMousePressed

    private void lblAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseEntered
        lblAgregar.setForeground(Color.GREEN);
    }//GEN-LAST:event_lblAgregarMouseEntered

    private void lblCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCargoMouseEntered
        lblCargo.setForeground(Color.GREEN);    }//GEN-LAST:event_lblCargoMouseEntered

    private void lblTurnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTurnoMouseEntered
        lblTurno.setForeground(Color.GREEN);    }//GEN-LAST:event_lblTurnoMouseEntered

    private void lblAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarMouseExited
        lblAgregar.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAgregarMouseExited

    private void lblCargoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCargoMouseExited
        lblCargo.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblCargoMouseExited

    private void lblTurnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTurnoMouseExited
        lblTurno.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblTurnoMouseExited

    private void lblAsistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsistenciasMouseClicked
        panel_asistencia_trabajadores a = new panel_asistencia_trabajadores();
        a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
        frm_principall.panel_principal.removeAll();
        frm_principall.panel_principal.add(a, BorderLayout.CENTER);
        frm_principall.panel_principal.revalidate();
        frm_principall.panel_principal.repaint();
    }//GEN-LAST:event_lblAsistenciasMouseClicked

    private void lblAsistenciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsistenciasMouseEntered
        lblAsistencias.setForeground(Color.RED);
    }//GEN-LAST:event_lblAsistenciasMouseEntered

    private void lblAsistenciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsistenciasMouseExited
        lblAsistencias.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblAsistenciasMouseExited

    private void lblAsistenciasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAsistenciasMousePressed
        lblAsistencias.setForeground(Color.GREEN);
    }//GEN-LAST:event_lblAsistenciasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel2;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel3;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel4;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblAsistencias;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblTurno;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojerusan.RSLabelImage rSLabelImage3;
    private rojerusan.RSLabelImage rSLabelImage4;
    // End of variables declaration//GEN-END:variables
}