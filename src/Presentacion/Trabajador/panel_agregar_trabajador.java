/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Trabajador;

import Dominio.Cargo;
import Dominio.Trabajador;
import Dominio.Turno;
import Persistencia.CargoDAO;
import Persistencia.TrabajadorDAO;
import Persistencia.TurnoDAO;
import Presentacionn.frm_principall;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.glass.events.KeyEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Levi
 */
public class panel_agregar_trabajador extends javax.swing.JPanel {

    private String Id_trabajador;
    private String Id_cargo;
    private String Id_turno;
    private String nombre;
    private String A_paterno;
    private String A_materno;
    private int DNI;
    private String Genero;
    private int Telefono;
    private String Direccion;
    private String E_mail;
    private String Estado;
    int indiceSeleccion;
    TrabajadorDAO trabajadorDAO;
    Trabajador trabajador;
    CargoDAO cargoDAO;
    TurnoDAO turnoDAO;

    public panel_agregar_trabajador() {
        initComponents();
        trabajadorDAO = new TrabajadorDAO();
        cargoDAO = new CargoDAO();
        turnoDAO = new TurnoDAO();
        obtenerDatos();
        limpiarCampos();
        enabledCampos(false);
        autocompleterCargo();
        autocompleterTurno();
    }

    void obtenerDatos() {
        DefaultTableModel modelo = trabajadorDAO.mostrar();
        tabla_cargo.setModel(modelo);
        ocultarColumnas();
    }

    public void autocompleterTurno() {
        TextAutoCompleter texto = new TextAutoCompleter(txtTurno);
        turnoDAO.cargarListaTurno();
        ArrayList<Turno> listaTurno = turnoDAO.listaTurno;
        for (Turno lista : listaTurno) {
            texto.addItem(lista.getDescripcion());
        }

    }

    public void autocompleterCargo() {
        TextAutoCompleter texto = new TextAutoCompleter(txtCargo);
        cargoDAO.cargarListaCargo();
        ArrayList<Cargo> listaCargo = cargoDAO.listaCargo;
        for (Cargo lista : listaCargo) {
            texto.addItem(lista.getNombre_de_cargo());
        }
    }

    void ocultarColumnas() {
        tabla_cargo.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_cargo.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_cargo.getColumnModel().getColumn(0).setPreferredWidth(0);

        tabla_cargo.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla_cargo.getColumnModel().getColumn(4).setMinWidth(0);
        tabla_cargo.getColumnModel().getColumn(4).setPreferredWidth(0);

        tabla_cargo.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla_cargo.getColumnModel().getColumn(5).setMinWidth(0);
        tabla_cargo.getColumnModel().getColumn(5).setPreferredWidth(0);

        tabla_cargo.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla_cargo.getColumnModel().getColumn(8).setMinWidth(0);
        tabla_cargo.getColumnModel().getColumn(8).setPreferredWidth(0);

        tabla_cargo.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla_cargo.getColumnModel().getColumn(9).setMinWidth(0);
        tabla_cargo.getColumnModel().getColumn(9).setPreferredWidth(0);

    }

    Trabajador recogerDatos() {
        Id_trabajador = txtCodigo.getText();
        Id_cargo = txtCargo.getText();
        Id_turno = txtTurno.getText();
        nombre = txtNombre.getText();
        A_paterno = txtPaterno.getText();
        A_materno = txtMaterno.getText();
        if (txtDni.getText().equals("")) {
            DNI = 0;
        } else {
            DNI = Integer.parseInt(txtDni.getText());
        }

        Genero = cbxGenero.getSelectedItem().toString();
        if (txtTelefono.getText().equals("")) {
            Telefono = 0;
        } else {
            Telefono = Integer.parseInt(txtTelefono.getText());
        }
        Direccion = txtDireccion.getText();
        E_mail = txtEmail.getText();
        if (Activo.isSelected()) {
            Estado = "Activo";
        } else {
            Estado = "Inactivo";
        }
        trabajador = new Trabajador(Id_trabajador, cargoDAO.devolverIdCargo(Id_cargo), turnoDAO.devolverIdTurno(Id_turno), nombre, A_paterno, A_materno, DNI, Genero, Telefono, Direccion, E_mail, Estado);
        return trabajador;
    }

    void limpiarCampos() {
        txtCodigo.setText(String.valueOf(trabajadorDAO.obtenerCodigo()));
        txtCargo.setText("");
        txtDireccion.setText("");
        txtDni.setText("");
        txtEmail.setText("");

        txtMaterno.setText("");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtTelefono.setText("");
        txtTurno.setText("");
    }

    void enabledCampos(boolean estado) {
        txtCodigo.setEnabled(false);
        txtCargo.setEnabled(estado);
        txtDireccion.setEnabled(estado);
        txtDni.setEnabled(estado);
        txtEmail.setEnabled(estado);
        cbxGenero.setEnabled(estado);
        txtMaterno.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtPaterno.setEnabled(estado);
        txtTelefono.setEnabled(estado);
        txtTurno.setEnabled(estado);
    }

    void ponerDatosCampos() {
        txtCodigo.setText(tabla_cargo.getValueAt(indiceSeleccion, 0).toString());
        txtCargo.setText(tabla_cargo.getValueAt(indiceSeleccion, 1).toString());
        txtTurno.setText(tabla_cargo.getValueAt(indiceSeleccion, 2).toString());
        txtNombre.setText(tabla_cargo.getValueAt(indiceSeleccion, 3).toString());
        txtPaterno.setText(tabla_cargo.getValueAt(indiceSeleccion, 4).toString());
        txtMaterno.setText(tabla_cargo.getValueAt(indiceSeleccion, 5).toString());
        txtDni.setText(tabla_cargo.getValueAt(indiceSeleccion, 6).toString());
        String genero = tabla_cargo.getValueAt(indiceSeleccion, 7).toString();
        cbxGenero.setSelectedItem(genero);
        txtTelefono.setText(tabla_cargo.getValueAt(indiceSeleccion, 8).toString());
        txtDireccion.setText(tabla_cargo.getValueAt(indiceSeleccion, 9).toString());
        txtEmail.setText(tabla_cargo.getValueAt(indiceSeleccion, 10).toString());
        String estado = tabla_cargo.getValueAt(indiceSeleccion, 11).toString();
        if (estado.equals("Activo")) {
            Activo.setSelected(true);
            Inactivo.setSelected(false);
        }
        if (estado.equals("Inactivo")) {

            Activo.setSelected(false);
            Inactivo.setSelected(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        nuevo = new rojerusan.RSButtonMetro();
        eliminar = new rojerusan.RSButtonMetro();
        jPanel3 = new javax.swing.JPanel();
        actualizar = new rojerusan.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        guardar = new rojerusan.RSButtonMetro();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new rojerusan.RSMetroTextFullPlaceHolder();
        txtCargo = new rojerusan.RSMetroTextFullPlaceHolder();
        Cargo = new javax.swing.JLabel();
        txtTurno = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel4 = new javax.swing.JLabel();
        txtPaterno = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel5 = new javax.swing.JLabel();
        txtMaterno = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel6 = new javax.swing.JLabel();
        txtDni = new rojerusan.RSMetroTextFullPlaceHolder();
        txtTelefono = new rojerusan.RSMetroTextFullPlaceHolder();
        txtDireccion = new rojerusan.RSMetroTextFullPlaceHolder();
        txtEmail = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Activo = new javax.swing.JRadioButton();
        Inactivo = new javax.swing.JRadioButton();
        verCargo = new rojeru_san.RSButton();
        verTurno = new rojeru_san.RSButton();
        jPanel7 = new javax.swing.JPanel();
        cbxGenero = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cargo = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 112, 192)));
        jPanel2.setToolTipText("");

        nuevo.setBackground(new java.awt.Color(0, 153, 204));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Cliente/Imagenes/IconoNuevo.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(0, 153, 255));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Trabajador/Imagenes/borrar.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 145, 234)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        actualizar.setBackground(new java.awt.Color(0, 153, 255));
        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Cliente/Imagenes/IconoActualizar.png"))); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 145, 234)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 145, 234)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        guardar.setBackground(new java.awt.Color(0, 153, 255));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Cliente/Imagenes/IconoGuardar.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 112, 192)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 33, -1, -1));

        txtCodigo.setPlaceholder("Código...");
        txtCodigo.setSoloNumeros(true);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 21, 221, -1));

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
        jPanel1.add(txtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 81, 221, -1));

        Cargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cargo.setText("Cargo");
        jPanel1.add(Cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 93, -1, -1));

        txtTurno.setPlaceholder("Turno...");
        txtTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTurnoActionPerformed(evt);
            }
        });
        txtTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTurnoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 141, 221, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Turno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 153, -1, -1));

        txtNombre.setPlaceholder("Nombre...");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 201, 221, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 213, -1, -1));

        txtPaterno.setPlaceholder("Paterno...");
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 254, 221, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Paterno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 266, -1, -1));

        txtMaterno.setPlaceholder("Materno...");
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 312, 221, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Materno");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 324, -1, -1));

        txtDni.setPlaceholder("Número de DNI...");
        txtDni.setSoloNumeros(true);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 13, 221, -1));

        txtTelefono.setPlaceholder("Teléfono...");
        txtTelefono.setSoloNumeros(true);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 121, 221, -1));

        txtDireccion.setPlaceholder("Dirección...");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 181, 221, -1));

        txtEmail.setPlaceholder("ejemplo@gmail.com");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 234, 221, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Estado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 324, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("E-mail");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 246, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Dirección");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 193, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Teléfono");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 133, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Género");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 83, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("DNI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 25, -1, -1));

        Activo.setForeground(new java.awt.Color(0, 112, 192));
        Activo.setSelected(true);
        Activo.setText("Activo");
        jPanel1.add(Activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 323, -1, -1));

        Inactivo.setForeground(new java.awt.Color(0, 112, 192));
        Inactivo.setText("Inactivo");
        jPanel1.add(Inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 323, -1, -1));

        verCargo.setText("Ver");
        verCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCargoActionPerformed(evt);
            }
        });
        jPanel1.add(verCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 82, 63, -1));

        verTurno.setText("Ver");
        verTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTurnoActionPerformed(evt);
            }
        });
        jPanel1.add(verTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 142, 63, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 112, 192)));
        jPanel7.setForeground(new java.awt.Color(0, 112, 192));

        cbxGenero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbxGenero.setForeground(new java.awt.Color(0, 112, 192));
        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "MASCULINO", "FEMENINO", "OTROS", "" }));
        cbxGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxGeneroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbxGenero, 0, 206, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(cbxGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 210, -1));

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
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        limpiarCampos();
        enabledCampos(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        String codigo = tabla_cargo.getValueAt(indiceSeleccion, 0).toString();
        trabajadorDAO.Eliminar(codigo);
        obtenerDatos();
        limpiarCampos();
        enabledCampos(false);
    }//GEN-LAST:event_eliminarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        trabajadorDAO.modificar(recogerDatos());
        limpiarCampos();
        obtenerDatos();
        enabledCampos(false);
    }//GEN-LAST:event_actualizarActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void tabla_cargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_cargoMousePressed
        indiceSeleccion = tabla_cargo.getSelectedRow();
        ponerDatosCampos();
        enabledCampos(true);
        nuevo.setBackground(new Color(0, 153, 153));
        eliminar.setBackground(new Color(0, 153, 153));
        guardar.setBackground(Color.RED);
        actualizar.setBackground(Color.RED);
    }//GEN-LAST:event_tabla_cargoMousePressed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        trabajadorDAO.agregar(recogerDatos());
        obtenerDatos();
        limpiarCampos();
    }//GEN-LAST:event_guardarActionPerformed

    private void verCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCargoActionPerformed
        panel_cargo_trabajador a = new panel_cargo_trabajador(this);
        cargoDAO.listaCargo.clear();
        a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
        frm_principall.panel_principal.removeAll();
        frm_principall.panel_principal.add(a, BorderLayout.CENTER);
        frm_principall.panel_principal.revalidate();
        frm_principall.panel_principal.repaint();
    }//GEN-LAST:event_verCargoActionPerformed

    private void verTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTurnoActionPerformed
        panel_turno_trabajador a = new panel_turno_trabajador(this);
        turnoDAO.listaTurno.clear();
        a.setBounds(0, 0, frm_principall.anchoPantalla - frm_principall.panel_opciones.getWidth(), frm_principall.alturaPantalla - frm_principall.panel_cabecera_principal.getHeight());
        frm_principall.panel_principal.removeAll();
        frm_principall.panel_principal.add(a, BorderLayout.CENTER);
        frm_principall.panel_principal.revalidate();
        frm_principall.panel_principal.repaint();
    }//GEN-LAST:event_verTurnoActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (txtCargo.getText().equals("")) {
            frm_principall.controladorErrores("falta ingresar cargo", "fail");
        }

        if (txtTurno.getText().equals("")) {
            frm_principall.controladorErrores("falta ingresar turno", "fail");
        }

    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtPaterno.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtMaterno.requestFocus();
        }


    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
           if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtCargo.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtTurno.requestFocus();
        }
    }//GEN-LAST:event_txtCargoKeyTyped

    private void txtTurnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTurnoKeyTyped
          if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_txtTurnoKeyTyped

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
          if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtDni.requestFocus();
        }
    }//GEN-LAST:event_txtMaternoKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
           if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            cbxGenero.requestFocus();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void cbxGeneroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxGeneroKeyTyped
            if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_cbxGeneroKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
            if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
              if(evt.getKeyChar() == KeyEvent.VK_ENTER ){
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTurnoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed
  
        public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        } else {
            return false;
        }
    }
    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
    if(isEmail(txtEmail.getText())){  
    }else{
        JOptionPane.showMessageDialog(null, "Error", "Validar Corre",JOptionPane.INFORMATION_MESSAGE);
        txtEmail.requestFocus();
    }

      
    }//GEN-LAST:event_txtEmailFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Activo;
    private javax.swing.JLabel Cargo;
    private javax.swing.JRadioButton Inactivo;
    private rojerusan.RSButtonMetro actualizar;
    private javax.swing.JComboBox<String> cbxGenero;
    private rojerusan.RSButtonMetro eliminar;
    private rojerusan.RSButtonMetro guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSButtonMetro nuevo;
    private javax.swing.JTable tabla_cargo;
    private rojerusan.RSMetroTextFullPlaceHolder txtCargo;
    private rojerusan.RSMetroTextFullPlaceHolder txtCodigo;
    private rojerusan.RSMetroTextFullPlaceHolder txtDireccion;
    private rojerusan.RSMetroTextFullPlaceHolder txtDni;
    private rojerusan.RSMetroTextFullPlaceHolder txtEmail;
    private rojerusan.RSMetroTextFullPlaceHolder txtMaterno;
    private rojerusan.RSMetroTextFullPlaceHolder txtNombre;
    private rojerusan.RSMetroTextFullPlaceHolder txtPaterno;
    private rojerusan.RSMetroTextFullPlaceHolder txtTelefono;
    private rojerusan.RSMetroTextFullPlaceHolder txtTurno;
    private rojeru_san.RSButton verCargo;
    private rojeru_san.RSButton verTurno;
    // End of variables declaration//GEN-END:variables
}
