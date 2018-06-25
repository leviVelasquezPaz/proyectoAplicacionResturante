/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Plato.TipoPlato;

import Dominio.Tipo_plato;
import Persistencia.Tipo_platoDAO;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio AB
 */
public class Panel_Registro_TipoPlato extends javax.swing.JPanel {

    Tipo_platoDAO tipoplatoDAO;
    private String Id_Tipo_plato;
    private String Nombre;
    private String Estado;
    int indicePosicion;

    public Panel_Registro_TipoPlato() {
        initComponents();
        tipoplatoDAO = new Tipo_platoDAO();
        obtenerDatos();
        limpiarTextos();
        enabledTextos(false);
    }

    void obtenerDatos() {
        DefaultTableModel model = tipoplatoDAO.mostrar();
        tablaTipoplato.setModel(model);
    }

    void enabledTextos(boolean estado) {
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(estado);
        Activo.setEnabled(estado);
        Inactivo.setEnabled(estado);
    }

    ///void metodos 
    void limpiarTextos() {
        txtCodigo.setText(String.valueOf(tipoplatoDAO.obtenerCodigo()));
        txtNombre.setText("");

    }

    Tipo_plato recogerDatos() {
        Tipo_plato tipoplato;
        Id_Tipo_plato = txtCodigo.getText();
        String nombre = txtNombre.getText();
        if (Activo.isSelected()) {
            Estado = "Activo";
        } else {
            Estado = "Inactivo";
        }
        tipoplato = new Tipo_plato(Id_Tipo_plato, nombre, Estado);
        return tipoplato;
    }

    void ponerDatosTexto() {
        txtCodigo.setText(tablaTipoplato.getValueAt(indicePosicion, 0).toString());
        txtNombre.setText(tablaTipoplato.getValueAt(indicePosicion, 1).toString());
        String estado = tablaTipoplato.getValueAt(indicePosicion, 0).toString();
        if (estado.equals("Activo")) {
            Activo.setSelected(true);
            Inactivo.setSelected(false);
        } else {
            Activo.setSelected(true);
            Inactivo.setSelected(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new rojerusan.RSMetroTextFullPlaceHolder();
        txtNombre = new rojerusan.RSMetroTextFullPlaceHolder();
        Activo = new javax.swing.JCheckBox();
        Inactivo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTipoplato = new rojerusan.RSTableMetro();
        nuevo = new rojerusan.RSButtonHover();
        agregar = new rojerusan.RSButtonHover();
        eliminar = new rojerusan.RSButtonHover();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234), 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Estado:");

        txtCodigo.setBorderColor(new java.awt.Color(0, 145, 234));
        txtCodigo.setBotonColor(new java.awt.Color(0, 145, 234));

        txtNombre.setBorderColor(new java.awt.Color(0, 145, 234));
        txtNombre.setBotonColor(new java.awt.Color(0, 145, 234));

        Activo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Activo);
        Activo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Activo.setText("Activo");

        Inactivo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Inactivo);
        Inactivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inactivo.setText("Inactivo");

        tablaTipoplato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tablaTipoplato.setAltoHead(35);
        tablaTipoplato.setColorBackgoundHead(new java.awt.Color(0, 145, 234));
        tablaTipoplato.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tablaTipoplato.setGrosorBordeFilas(0);
        tablaTipoplato.setGrosorBordeHead(0);
        tablaTipoplato.getTableHeader().setResizingAllowed(false);
        tablaTipoplato.getTableHeader().setReorderingAllowed(false);
        tablaTipoplato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaTipoplatoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTipoplato);

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Plato/TipoPlato/Imagenes/IconoNuevo.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Activo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Inactivo))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodigo, txtNombre});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Activo)
                            .addComponent(Inactivo))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCodigo, txtNombre});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiarTextos();
        enabledTextos(true);
        agregar.setText("Agregar");
        agregar.setBackground(Color.red);
        eliminar.setBackground(new Color(0, 112, 192));
        nuevo.setBackground(new Color(0, 112, 192));

    }//GEN-LAST:event_nuevoActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (agregar.getText().equals("Actualizar")) {
            tipoplatoDAO.modificar(recogerDatos());
            obtenerDatos();
            limpiarTextos();
            enabledTextos(false);
            agregar.setBackground(new Color(0, 112, 192));
            eliminar.setBackground(new Color(0, 112, 192));
            nuevo.setBackground(Color.RED);
        }

        if (agregar.getText().equals("Agregar")) {
            tipoplatoDAO.agregar(recogerDatos());
            obtenerDatos();
            limpiarTextos();
            enabledTextos(false);
            agregar.setBackground(new Color(0, 112, 192));
            eliminar.setBackground(new Color(0, 112, 192));
            nuevo.setBackground(Color.RED);
        }

    }//GEN-LAST:event_agregarActionPerformed

    private void tablaTipoplatoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTipoplatoMousePressed
        indicePosicion = tablaTipoplato.getSelectedRow();
        ponerDatosTexto();
        agregar.setText("Actualizar");
        agregar.setBackground(Color.red);
        eliminar.setBackground(Color.red);
        nuevo.setBackground(new Color(0, 112, 192));

    }//GEN-LAST:event_tablaTipoplatoMousePressed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String codigo = tablaTipoplato.getValueAt(indicePosicion, 0).toString();
        tipoplatoDAO.Eliminar(codigo);
        obtenerDatos();
        limpiarTextos();
        enabledTextos(false);
        agregar.setBackground(Color.RED);
        eliminar.setBackground(Color.RED);
        nuevo.setBackground(new Color(0, 112, 192));
    }//GEN-LAST:event_eliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Activo;
    private javax.swing.JCheckBox Inactivo;
    private rojerusan.RSButtonHover agregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private rojerusan.RSButtonHover eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSButtonHover nuevo;
    private rojerusan.RSTableMetro tablaTipoplato;
    private rojerusan.RSMetroTextFullPlaceHolder txtCodigo;
    private rojerusan.RSMetroTextFullPlaceHolder txtNombre;
    // End of variables declaration//GEN-END:variables
}
