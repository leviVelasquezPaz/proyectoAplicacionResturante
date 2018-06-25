/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Trabajador;

import Dominio.Cargo;
import Dominio.Turno;
import Persistencia.TurnoDAO;
import static Presentacionn.frm_principall.alturaPantalla;
import static Presentacionn.frm_principall.anchoPantalla;
import static Presentacionn.frm_principall.panel_cabecera_principal;
import static Presentacionn.frm_principall.panel_opciones;
import static Presentacionn.frm_principall.panel_principal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Levi
 */
public class panel_turno_trabajador extends javax.swing.JPanel {

    int indiceSeleccion;

    private String Id_turno;
    private String descripcion;
    private String Hora_Inicio;
    private String Hora_salida;
    private String estado;
    TurnoDAO turnoDAO;
    Turno turno;
    panel_agregar_trabajador panel_agregar;

    public panel_turno_trabajador() {
        initComponents();
        turnoDAO = new TurnoDAO();
        obtenerDatos();
        limpiarCampos();
        enabledCampos(false);

    }

    public panel_turno_trabajador(panel_agregar_trabajador a) {
        initComponents();
        turnoDAO = new TurnoDAO();
        obtenerDatos();
        limpiarCampos();
        enabledCampos(false);
        this.panel_agregar = a;

    }

//metodos
    void obtenerDatos() {
        DefaultTableModel modelo = turnoDAO.mostrar();
        tabla_cargo.setModel(modelo);
    }

    Turno recogerDatos() {
        Id_turno = txtid_turno.getText();
        descripcion = txtDescripcion.getText();
        Hora_Inicio = txtHora_inicio.getText();
        Hora_salida = txtHora_fin.getText();

        if (Activo.isSelected()) {
            estado = "Activo";
        } else {
            estado = "Inactivo";
        }
        turno = new Turno(Id_turno, descripcion, Hora_Inicio, Hora_salida, estado);
        return turno;
    }

    void limpiarCampos() {
        txtid_turno.setText(String.valueOf(turnoDAO.obtenerCodigo()));
        txtDescripcion.setText("");
        txtHora_inicio.setText("");
        txtHora_fin.setText("");
    }

    void enabledCampos(boolean estado) {
        txtDescripcion.setEnabled(estado);
        txtHora_inicio.setEnabled(estado);
        txtHora_fin.setEnabled(estado);
        Activo.setEnabled(estado);
        Inactivo.setEnabled(estado);
    }

    void ponerDatosCampos() {
        txtid_turno.setText(tabla_cargo.getValueAt(indiceSeleccion, 0).toString());
        txtDescripcion.setText(tabla_cargo.getValueAt(indiceSeleccion, 1).toString());
        txtHora_inicio.setText(tabla_cargo.getValueAt(indiceSeleccion, 2).toString());
        txtHora_fin.setText(tabla_cargo.getValueAt(indiceSeleccion, 3).toString());
        String estado = tabla_cargo.getValueAt(indiceSeleccion, 4).toString();
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
        txtid_turno = new rojerusan.RSMetroTextFullPlaceHolder();
        txtDescripcion = new rojerusan.RSMetroTextFullPlaceHolder();
        Cargo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHora_inicio = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel4 = new javax.swing.JLabel();
        txtHora_fin = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        agregar = new rojerusan.RSButtonMetro();
        nuevo = new rojerusan.RSButtonMetro();
        actulizar = new rojerusan.RSButtonMetro();
        eliminar = new rojerusan.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        Activo = new javax.swing.JRadioButton();
        Inactivo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cargo = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 112, 192)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Turno Trabajadores");

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
                .addGap(21, 21, 21)
                .addComponent(lblAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAtras)
                    .addComponent(jLabel1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Codigo:");

        txtid_turno.setPlaceholder("Código...");
        txtid_turno.setSoloNumeros(true);
        txtid_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_turnoActionPerformed(evt);
            }
        });
        txtid_turno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_turnoKeyTyped(evt);
            }
        });

        txtDescripcion.setPlaceholder("Descripción...");
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        Cargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cargo.setText("Descripción");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Hora Incio");

        txtHora_inicio.setPlaceholder("Hora Inicio...");
        txtHora_inicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHora_inicioKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        txtHora_fin.setPlaceholder("Hora Fin...");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hora Fin");

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 112, 192)));

        agregar.setBackground(new java.awt.Color(0, 255, 255));
        agregar.setForeground(new java.awt.Color(0, 0, 0));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/add2.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        nuevo.setBackground(new java.awt.Color(0, 255, 255));
        nuevo.setForeground(new java.awt.Color(0, 0, 0));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Cliente/Imagenes/IconoNuevo.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        actulizar.setBackground(new java.awt.Color(0, 255, 255));
        actulizar.setForeground(new java.awt.Color(0, 0, 0));
        actulizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/to update.png"))); // NOI18N
        actulizar.setText("Actualizar");
        actulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actulizarActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(0, 255, 255));
        eliminar.setForeground(new java.awt.Color(51, 51, 51));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/borrar.png"))); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(actulizar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actulizar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 112, 192)));
        jPanel4.setForeground(new java.awt.Color(0, 112, 192));

        Activo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Activo.setForeground(new java.awt.Color(0, 112, 192));
        Activo.setSelected(true);
        Activo.setText("Activo");

        Inactivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inactivo.setForeground(new java.awt.Color(0, 112, 192));
        Inactivo.setText("Inactivo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(Inactivo)
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inactivo)
                    .addComponent(Activo))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cargo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtid_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cargo)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabla_cargo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 112, 192)));
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
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        turnoDAO.agregar(recogerDatos());
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
        turnoDAO.modificar(recogerDatos());
        limpiarCampos();

        nuevo.setBackground(Color.RED);
        agregar.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(new Color(0, 153, 153));
        actulizar.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_actulizarActionPerformed

    private void tabla_cargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_cargoMousePressed
        indiceSeleccion = tabla_cargo.getSelectedRow();
        ponerDatosCampos();

        nuevo.setBackground(new Color(0, 153, 153));
        agregar.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(Color.RED);
        actulizar.setBackground(Color.RED);
    }//GEN-LAST:event_tabla_cargoMousePressed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String id = tabla_cargo.getValueAt(indiceSeleccion, 0).toString();
        turnoDAO.Eliminar(id);
        limpiarCampos();
        obtenerDatos();

        nuevo.setBackground(Color.RED);
        agregar.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(new Color(0, 153, 153));
        actulizar.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_eliminarActionPerformed

    private void lblAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMousePressed
        lblAtras.setBackground(Color.RED);
    }//GEN-LAST:event_lblAtrasMousePressed

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked

        if (panel_home_trabajador.estadoTurno) {
            panel_home_trabajador a = new panel_home_trabajador();
            a.setBounds(0, 0, anchoPantalla - panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
            panel_principal.removeAll();
            panel_principal.add(a, BorderLayout.CENTER);
            panel_principal.revalidate();
            panel_principal.repaint();
            panel_home_trabajador.estadoTurno = false;
        } else {
            panel_agregar_trabajador a = new panel_agregar_trabajador();
            a.setBounds(0, 0, anchoPantalla - panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
            panel_principal.removeAll();
            panel_principal.add(a, BorderLayout.CENTER);
            panel_principal.revalidate();
            panel_principal.repaint();
            panel_agregar.autocompleterTurno();
        }

    }//GEN-LAST:event_lblAtrasMouseClicked

    private void txtid_turnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_turnoKeyTyped
         if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtid_turnoKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
         if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtHora_inicio.requestFocus();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtHora_inicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHora_inicioKeyTyped
         if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtHora_fin.requestFocus();
        }
    }//GEN-LAST:event_txtHora_inicioKeyTyped

    private void txtid_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_turnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_turnoActionPerformed


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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtras;
    private rojerusan.RSButtonMetro nuevo;
    private javax.swing.JTable tabla_cargo;
    private rojerusan.RSMetroTextFullPlaceHolder txtDescripcion;
    private rojerusan.RSMetroTextFullPlaceHolder txtHora_fin;
    private rojerusan.RSMetroTextFullPlaceHolder txtHora_inicio;
    private rojerusan.RSMetroTextFullPlaceHolder txtid_turno;
    // End of variables declaration//GEN-END:variables
}
