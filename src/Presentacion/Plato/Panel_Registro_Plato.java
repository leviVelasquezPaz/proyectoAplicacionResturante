/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Plato;

import Dominio.CargarIamgenCategoria;
import Dominio.Plato;
import Dominio.Tipo_plato;
import Persistencia.PlatoDAO;
import Persistencia.Tipo_platoDAO;
import Presentacionn.frm_principall;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio AB
 */
public class Panel_Registro_Plato extends javax.swing.JPanel {

    public static String codigo = "";

    private String Id_plato;
    private String Id_tipoPlato;
    private String nombre;
    private double PrecioVenta;
    private String Estado;
    private Tipo_platoDAO tipoPlatoDAO;
    PlatoDAO plataDAO;
    private String ImagenRuta = "";
    int indiceSeleccion;
    CargarIamgenCategoria cargarImagenMeto = new CargarIamgenCategoria() {

    };

    public Panel_Registro_Plato() {
        initComponents();
        tipoPlatoDAO = new Tipo_platoDAO();
        plataDAO = new PlatoDAO();
        Menu.add(pnlOpcionesP);
        AutoCompleter();
        enabledTextos(false);
        limpiarTextos();
        obtenerDatos();
    }

    void obtenerDatos() {
        DefaultTableModel model = plataDAO.mostrar();
        tablaPlatos.setModel(model);
        ocultarColumnas();
    }

    void ocultarColumnas() {
        tablaPlatos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaPlatos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaPlatos.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablaPlatos.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaPlatos.getColumnModel().getColumn(4).setMinWidth(0);
        tablaPlatos.getColumnModel().getColumn(4).setPreferredWidth(0);

    }

    void enabledTextos(boolean estado) {
        txtNombre.setEnabled(estado);
        txtPrecioVenta.setEnabled(estado);
        txtTipoPlato.setEnabled(estado);
        Activo.setEnabled(estado);
        Inactivo.setEnabled(estado);
    }

    void AutoCompleter() {
        tipoPlatoDAO.cargarLisaTipoPlato();
        TextAutoCompleter texto = new TextAutoCompleter(txtTipoPlato);
        ArrayList<Tipo_plato> listaTipoPlato = tipoPlatoDAO.listaPlato;
        for (Tipo_plato lista : listaTipoPlato) {
            texto.addItem(lista.getNombre());
        }
    }

    ///void metodos 
    void limpiarTextos() {
        txtCodigo.setText(String.valueOf(plataDAO.obtenerId()));
        txtNombre.setText("");
        txtPrecioVenta.setText("");
        txtTipoPlato.setText("");
    }

    Plato recogerDatos() {
        Plato plato;
        Id_plato = txtCodigo.getText();
        String tipoPlato = txtTipoPlato.getText();
        nombre = txtNombre.getText();
        if (txtPrecioVenta.getText().equals("")) {
            PrecioVenta = 0.0;
        } else {
            PrecioVenta = Double.parseDouble(txtPrecioVenta.getText());
        }
        if (Activo.isSelected()) {
            Estado = "Activo";
        } else {
            Estado = "Inactivo";
        }
        plato = new Plato(Id_plato, tipoPlatoDAO.obtenerCodigoTipoPlato(tipoPlato), nombre, PrecioVenta, ImagenRuta, Estado);
        return plato;
    }

    void ponerDatosTexto() {
        txtCodigo.setText(tablaPlatos.getValueAt(indiceSeleccion, 0).toString());
        txtTipoPlato.setText(tablaPlatos.getValueAt(indiceSeleccion, 1).toString());
        txtNombre.setText(tablaPlatos.getValueAt(indiceSeleccion, 2).toString());
        txtPrecioVenta.setText(tablaPlatos.getValueAt(indiceSeleccion, 3).toString());

        String urlImagen = tablaPlatos.getValueAt(indiceSeleccion, 4).toString();

        String estado = tablaPlatos.getValueAt(indiceSeleccion, 5).toString();
        cargarImagenMeto.cargarImagen(urlImagen);
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

        pnlOpcionesP = new javax.swing.JPanel();
        btnEditar = new rojerusan.RSButtonPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnEliminar = new rojerusan.RSButtonPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Menu = new rojerusan.RSPopuMenu();
        Modificar = new javax.swing.ButtonGroup();
        panel_escritorio = new javax.swing.JPanel();
        panel_agregar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        rSButtonHover2 = new rojerusan.RSButtonHover();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatos = new rojerusan.RSTableMetro();
        txtTipoPlato = new rojeru_san.RSMTextFull();
        txtNombre = new rojeru_san.RSMTextFull();
        txtCodigo = new rojeru_san.RSMTextFull();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioVenta = new rojeru_san.RSMTextFull();
        Activo = new javax.swing.JRadioButton();
        Inactivo = new javax.swing.JRadioButton();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        btnImportar = new rojerusan.RSButtonHover();
        ImportarImagen = new org.edisoncor.gui.panel.Panel();

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setColorHover(new java.awt.Color(240, 240, 240));
        btnEditar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditarMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 112, 192));
        jLabel8.setText("Editar");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Plato/Imagenes/IconoEditar.png"))); // NOI18N

        javax.swing.GroupLayout btnEditarLayout = new javax.swing.GroupLayout(btnEditar);
        btnEditar.setLayout(btnEditarLayout);
        btnEditarLayout.setHorizontalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarLayout.createSequentialGroup()
                .addGap(0, 62, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnEditarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        btnEditarLayout.setVerticalGroup(
            btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setColorHover(new java.awt.Color(240, 240, 240));
        btnEliminar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 112, 192));
        jLabel10.setText("Eliminar");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Plato/Imagenes/IconoEliminar.png"))); // NOI18N

        javax.swing.GroupLayout btnEliminarLayout = new javax.swing.GroupLayout(btnEliminar);
        btnEliminar.setLayout(btnEliminarLayout);
        btnEliminarLayout.setHorizontalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminarLayout.createSequentialGroup()
                .addGap(0, 62, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnEliminarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        btnEliminarLayout.setVerticalGroup(
            btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btnEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlOpcionesPLayout = new javax.swing.GroupLayout(pnlOpcionesP);
        pnlOpcionesP.setLayout(pnlOpcionesPLayout);
        pnlOpcionesPLayout.setHorizontalGroup(
            pnlOpcionesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlOpcionesPLayout.setVerticalGroup(
            pnlOpcionesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesPLayout.createSequentialGroup()
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuMousePressed(evt);
            }
        });

        panel_agregar.setBackground(new java.awt.Color(255, 255, 255));
        panel_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234), 4));

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 145, 234)));

        rSButtonHover1.setText("Nuevo");
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });

        rSButtonHover2.setText("Agregar");
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButtonHover2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonHover2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jXSearchField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 145, 234)));
        jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tablaPlatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPlatos.setAltoHead(35);
        tablaPlatos.setComponentPopupMenu(Menu);
        tablaPlatos.setGrosorBordeFilas(0);
        tablaPlatos.setGrosorBordeHead(0);
        tablaPlatos.getTableHeader().setResizingAllowed(false);
        tablaPlatos.getTableHeader().setReorderingAllowed(false);
        tablaPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPlatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPlatos);

        txtTipoPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoPlatoKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("IdCodigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tipo Plato:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Precio Venta:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Estado:");

        Activo.setBackground(new java.awt.Color(255, 255, 255));
        Modificar.add(Activo);
        Activo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Activo.setSelected(true);
        Activo.setText("Activo");

        Inactivo.setBackground(new java.awt.Color(255, 255, 255));
        Modificar.add(Inactivo);
        Inactivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Inactivo.setText("Inactivo");

        jXTitledPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234), 2));

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        ImportarImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234)));
        ImportarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Plato/Imagenes/IconoImportar.png"))); // NOI18N

        javax.swing.GroupLayout ImportarImagenLayout = new javax.swing.GroupLayout(ImportarImagen);
        ImportarImagen.setLayout(ImportarImagenLayout);
        ImportarImagenLayout.setHorizontalGroup(
            ImportarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        ImportarImagenLayout.setVerticalGroup(
            ImportarImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_agregarLayout = new javax.swing.GroupLayout(panel_agregar);
        panel_agregar.setLayout(panel_agregarLayout);
        panel_agregarLayout.setHorizontalGroup(
            panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_agregarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_agregarLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_agregarLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_agregarLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtTipoPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_agregarLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(ImportarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_agregarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
            .addGroup(panel_agregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_agregarLayout.createSequentialGroup()
                        .addGap(0, 547, Short.MAX_VALUE)
                        .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_agregarLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panel_agregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_agregarLayout.createSequentialGroup()
                        .addComponent(Activo)
                        .addGap(18, 18, 18)
                        .addComponent(Inactivo))))
        );
        panel_agregarLayout.setVerticalGroup(
            panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_agregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_agregarLayout.createSequentialGroup()
                        .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_agregarLayout.createSequentialGroup()
                                .addComponent(ImportarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_agregarLayout.createSequentialGroup()
                                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(11, 11, 11)
                                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTipoPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(20, 20, 20)
                                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panel_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Activo)
                    .addComponent(Inactivo))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_escritorioLayout = new javax.swing.GroupLayout(panel_escritorio);
        panel_escritorio.setLayout(panel_escritorioLayout);
        panel_escritorioLayout.setHorizontalGroup(
            panel_escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_escritorioLayout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(panel_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        panel_escritorioLayout.setVerticalGroup(
            panel_escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_escritorioLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(panel_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel_escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMousePressed
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
//            this.menuP.setVisible(false);
//            int fila = this.tablaPlatos.getSelectedRow();
//            codigo = this.tablaPlatos.getValueAt(fila, 0).toString();

            Panel_Modificar_Plato modificar = new Panel_Modificar_Plato(null, true);
            Panel_Modificar_Plato.txtId.setText(txtCodigo.getText());
            Panel_Modificar_Plato.txtNombre.setText(txtNombre.getText());
            Panel_Modificar_Plato.txtPrecioVenta.setText(txtPrecioVenta.getText());
            Panel_Modificar_Plato.txtTipoPlato.setText(txtTipoPlato.getText());
            if (Activo.isSelected()) {
                Panel_Modificar_Plato.Activo.setSelected(true);
                Panel_Modificar_Plato.Activo.setSelected(false);
            } else {
                Panel_Modificar_Plato.Activo.setSelected(false);
                Panel_Modificar_Plato.Activo.setSelected(true);
            }
            modificar.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarMousePressed

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
//           this.menuP.setVisible(false);
            //      int fila = this.tablaPlatos.getSelectedRow();
            //      codigo = this.tablaPlatos.getValueAt(fila, 0).toString();
//          
        }
    }//GEN-LAST:event_btnEliminarMousePressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtTipoPlato.requestFocus();
        }

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtTipoPlatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoPlatoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtNombre.requestFocus();
        }

    }//GEN-LAST:event_txtTipoPlatoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtPrecioVenta.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        limpiarTextos();
        enabledTextos(true);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        plataDAO.agregar(recogerDatos());
        obtenerDatos();
        limpiarTextos();
        enabledTextos(false);
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void MenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMousePressed

    }//GEN-LAST:event_MenuMousePressed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        ImportarImagen.removeAll();

        cargarImagenMeto.abrirPaneldeImagen(ImportarImagen);

        ImagenRuta = cargarImagenMeto.ObtnerURL();
    }//GEN-LAST:event_btnImportarActionPerformed

    private void tablaPlatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlatosMousePressed
        indiceSeleccion = tablaPlatos.getSelectedRow();
    }//GEN-LAST:event_tablaPlatosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Activo;
    private org.edisoncor.gui.panel.Panel ImportarImagen;
    private javax.swing.JRadioButton Inactivo;
    private rojerusan.RSPopuMenu Menu;
    private javax.swing.ButtonGroup Modificar;
    private rojerusan.RSButtonPane btnEditar;
    private rojerusan.RSButtonPane btnEliminar;
    private rojerusan.RSButtonHover btnImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    public static javax.swing.JPanel panel_agregar;
    public static javax.swing.JPanel panel_escritorio;
    private javax.swing.JPanel pnlOpcionesP;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSButtonHover rSButtonHover2;
    private rojerusan.RSTableMetro tablaPlatos;
    private rojeru_san.RSMTextFull txtCodigo;
    private rojeru_san.RSMTextFull txtNombre;
    private rojeru_san.RSMTextFull txtPrecioVenta;
    private rojeru_san.RSMTextFull txtTipoPlato;
    // End of variables declaration//GEN-END:variables
}
