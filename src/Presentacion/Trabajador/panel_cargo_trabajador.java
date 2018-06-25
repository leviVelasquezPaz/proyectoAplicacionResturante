/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Trabajador;

import Dominio.Cargo;
import Persistencia.CargoDAO;
import Presentacionn.frm_principall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Levi
 */
public class panel_cargo_trabajador extends javax.swing.JPanel {

    CargoDAO cargoDAO;
    Cargo cargo;
    int indiceSeleccion;
    panel_agregar_trabajador panel_agregar;

    public panel_cargo_trabajador() {
        initComponents();
        cargoDAO = new CargoDAO();
        obtenerDatos();
        enabledCampos(false);
        limpiarCampos();

    }

    public panel_cargo_trabajador(panel_agregar_trabajador a) {
        initComponents();
        cargoDAO = new CargoDAO();
        obtenerDatos();
        enabledCampos(false);
        limpiarCampos();
        this.panel_agregar = a;

    }
//metodos

    void obtenerDatos() {
        DefaultTableModel modelo = cargoDAO.mostrar();
        tabla_cargo.setModel(modelo);
    }

    Cargo recogerDatos() {
        String id = txtId.getText();
        String nombre_cargo = txtCargo.getText();
        double sueldo = Double.parseDouble(txtSueldo.getText());
        String estado = "";
        if (Activo.isSelected()) {
            estado = "Activo";
        } else {
            estado = "Inactivo";
        }
        cargo = new Cargo(id, nombre_cargo, sueldo, estado);
        return cargo;
    }

    void limpiarCampos() {
        txtId.setText(String.valueOf(cargoDAO.obtenerCodigo()));
        txtCargo.setText("");
        txtSueldo.setText("");
    }

    void enabledCampos(boolean estado) {
        txtCargo.setEnabled(estado);
        txtSueldo.setEnabled(estado);
        Activo.setEnabled(estado);
        Inactivo.setEnabled(estado);
    }

    void ponerDatosCampos() {
        txtId.setText(tabla_cargo.getValueAt(indiceSeleccion, 0).toString());
        txtCargo.setText(tabla_cargo.getValueAt(indiceSeleccion, 1).toString());
        txtSueldo.setText(tabla_cargo.getValueAt(indiceSeleccion, 2).toString());
        String estado = tabla_cargo.getValueAt(indiceSeleccion, 2).toString();
        if (estado.equals("Activo")) {
            Activo.setSelected(true);
            Inactivo.setSelected(false);
        } else {
            Activo.setSelected(false);
            Inactivo.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new rojerusan.RSMetroTextFullPlaceHolder();
        txtCargo = new rojerusan.RSMetroTextFullPlaceHolder();
        Cargo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSueldo = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Activo = new javax.swing.JRadioButton();
        Inactivo = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        agregar = new rojerusan.RSButtonMetro();
        nuevo = new rojerusan.RSButtonMetro();
        actulizar = new rojerusan.RSButtonMetro();
        eliminar = new rojerusan.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cargo = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 0, 153)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cargo trabajadores");

        lblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3788_-_Undo-32.png"))); // NOI18N
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAtrasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(356, 356, 356)
                .addComponent(jLabel1)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAtras)
                    .addComponent(jLabel1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Codigo");

        txtId.setPlaceholder("Código...");
        txtId.setSoloNumeros(true);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtCargo.setPlaceholder("Cargo...");
        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });
        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCargoKeyTyped(evt);
            }
        });

        Cargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cargo.setText("Cargo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Sueldo");

        txtSueldo.setPlaceholder("Sueldo...");
        txtSueldo.setSoloNumeros(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Estado");

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 112, 192)));

        Activo.setForeground(new java.awt.Color(0, 112, 192));
        Activo.setSelected(true);
        Activo.setText("Activo");

        Inactivo.setForeground(new java.awt.Color(0, 112, 192));
        Inactivo.setText("Inactivo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Activo)
                .addGap(32, 32, 32)
                .addComponent(Inactivo)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Activo)
                    .addComponent(Inactivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cargo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cargo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 204)));

        agregar.setBackground(new java.awt.Color(0, 153, 153));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/agregar.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        nuevo.setBackground(new java.awt.Color(0, 153, 153));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/nuevo.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        actulizar.setBackground(new java.awt.Color(0, 153, 153));
        actulizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/actualizar.png"))); // NOI18N
        actulizar.setText("Actualizar");
        actulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actulizarActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(0, 153, 153));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/delete.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actulizar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actulizar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tabla_cargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_cargo.setRowHeight(25);
        tabla_cargo.setRowMargin(3);
        tabla_cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_cargoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_cargo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        cargoDAO.agregar(recogerDatos());
        obtenerDatos();
        enabledCampos(false);
        nuevo.setBackground(Color.RED);
        agregar.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(new Color(0, 153, 153));
        actulizar.setBackground(new Color(0, 153, 153));

    }//GEN-LAST:event_agregarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiarCampos();
        enabledCampos(true);
        nuevo.setBackground(new Color(0, 153, 153));
        agregar.setBackground(Color.RED);
        eliminar.setBackground(new Color(0, 153, 153));
        actulizar.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_nuevoActionPerformed

    private void actulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actulizarActionPerformed
        cargoDAO.modificar(cargo);
        limpiarCampos();
        nuevo.setBackground(Color.RED);
        agregar.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(new Color(0, 153, 153));
        actulizar.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_actulizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String id = tabla_cargo.getValueAt(indiceSeleccion, 0).toString();
        cargoDAO.Eliminar(id);
        limpiarCampos();
        obtenerDatos();

        nuevo.setBackground(Color.RED);
        agregar.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(new Color(0, 153, 153));
        actulizar.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_eliminarActionPerformed

    private void tabla_cargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_cargoMousePressed
        indiceSeleccion = tabla_cargo.getSelectedRow();
        ponerDatosCampos();

        nuevo.setBackground(new Color(0, 153, 153));
        agregar.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(Color.RED);
        actulizar.setBackground(Color.RED);

    }//GEN-LAST:event_tabla_cargoMousePressed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked

        if (panel_home_trabajador.estadoCargo) {
            panel_home_trabajador a = new panel_home_trabajador();
            a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
            frm_principall.panel_principal.removeAll();
            frm_principall.panel_principal.add(a, BorderLayout.CENTER);
            frm_principall.panel_principal.revalidate();
            frm_principall.panel_principal.repaint();
            panel_home_trabajador.estadoCargo = false;
        } else {
            panel_agregar_trabajador a = new panel_agregar_trabajador();
            a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
            frm_principall.panel_principal.removeAll();
            frm_principall.panel_principal.add(a, BorderLayout.CENTER);
            frm_principall.panel_principal.revalidate();
            frm_principall.panel_principal.repaint();
            panel_agregar.autocompleterCargo();

        }


    }//GEN-LAST:event_lblAtrasMouseClicked

    private void lblAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMousePressed
        lblAtras.setBackground(Color.RED);
    }//GEN-LAST:event_lblAtrasMousePressed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
              if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtCargo.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
           if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtSueldo.requestFocus();
        }
    }//GEN-LAST:event_txtCargoKeyTyped

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Activo;
    private javax.swing.JLabel Cargo;
    private javax.swing.JRadioButton Inactivo;
    private rojerusan.RSButtonMetro actulizar;
    private rojerusan.RSButtonMetro agregar;
    private rojerusan.RSButtonMetro eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtras;
    private rojerusan.RSButtonMetro nuevo;
    private javax.swing.JTable tabla_cargo;
    private rojerusan.RSMetroTextFullPlaceHolder txtCargo;
    private rojerusan.RSMetroTextFullPlaceHolder txtId;
    private rojerusan.RSMetroTextFullPlaceHolder txtSueldo;
    // End of variables declaration//GEN-END:variables
}
