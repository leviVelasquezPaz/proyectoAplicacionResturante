/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacionn;

import Presentacion.Cliente.Panel_Home_Cliente;
import Presentacion.Plato.Panel_Home_Plato;
import Presentacion.Proveedor.Panel_Home_Proveedor;
import Presentacion.Trabajador.panel_home_trabajador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Levi
 */
public class frm_principall extends javax.swing.JFrame {

    public static int anchoPantalla, alturaPantalla;

    public frm_principall() {
        initComponents();
        setVisible(true);
        toolkit();
        posicionar();
    }

    public static void controladorErrores(String titulo, String quienActiva) {
        Aviso a = new Aviso(titulo, quienActiva, anchoPantalla / 2);
        a.setVisible(true);
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setVisible(false);
            }
        });
        timer.start();

    }

    void toolkit() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension miPantalla = tk.getScreenSize();
        anchoPantalla = miPantalla.width;
        alturaPantalla = miPantalla.height;
        this.setBounds(0, 0, anchoPantalla, alturaPantalla);
    }

    //VOID METODOS
    void posicionar() {
        panel_opciones.setBounds(0, panel_cabecera_principal.getHeight(), panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
        panel_cabecera_principal.setBounds(0, 0, anchoPantalla, panel_cabecera_principal.getHeight());
        panel_principal.setBounds(panel_opciones.getWidth(), panel_cabecera_principal.getHeight(), anchoPantalla - panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
        System.out.println("ancho " + (panel_opciones.getWidth()));
        System.out.println("altura " + (alturaPantalla - panel_cabecera_principal.getHeight()));
        panel_adebajo.removeAll();
        panel_adebajo.add(panel_cabecera_principal, BorderLayout.CENTER);
        panel_adebajo.add(panel_opciones, BorderLayout.CENTER);
        panel_adebajo.add(panel_principal, BorderLayout.CENTER);
        panel_adebajo.revalidate();
        panel_adebajo.repaint();
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(220, 220, 220));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(255, 255, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_adebajo = new javax.swing.JPanel();
        panel_cabecera_principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        panel_opciones = new javax.swing.JPanel();
        trabajador = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cliente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        platos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Proveedor = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panel_principal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel_cabecera_principal.setBackground(new java.awt.Color(0, 145, 234));
        panel_cabecera_principal.setPreferredSize(new java.awt.Dimension(84, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3788_-_Undo-32.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        rSButtonMetro1.setBackground(new java.awt.Color(255, 0, 0));
        rSButtonMetro1.setText("x");
        rSButtonMetro1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rSButtonMetro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonMetro1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_cabecera_principalLayout = new javax.swing.GroupLayout(panel_cabecera_principal);
        panel_cabecera_principal.setLayout(panel_cabecera_principalLayout);
        panel_cabecera_principalLayout.setHorizontalGroup(
            panel_cabecera_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cabecera_principalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_cabecera_principalLayout.setVerticalGroup(
            panel_cabecera_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cabecera_principalLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_cabecera_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel_opciones.setBackground(new java.awt.Color(255, 255, 255));
        panel_opciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 145, 234)));

        trabajador.setBackground(new java.awt.Color(255, 255, 255));
        trabajador.setPreferredSize(new java.awt.Dimension(200, 40));
        trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trabajadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trabajadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trabajadorMouseExited(evt);
            }
        });

        jLabel5.setText("Trabajadores");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout trabajadorLayout = new javax.swing.GroupLayout(trabajador);
        trabajador.setLayout(trabajadorLayout);
        trabajadorLayout.setHorizontalGroup(
            trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(51, 51, 51))
        );
        trabajadorLayout.setVerticalGroup(
            trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trabajadorLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        Cliente.setBackground(new java.awt.Color(255, 255, 255));
        Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClienteMouseExited(evt);
            }
        });

        jLabel3.setText("Cliente");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout ClienteLayout = new javax.swing.GroupLayout(Cliente);
        Cliente.setLayout(ClienteLayout);
        ClienteLayout.setHorizontalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        ClienteLayout.setVerticalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        platos.setBackground(new java.awt.Color(255, 255, 255));
        platos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                platosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                platosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                platosMouseExited(evt);
            }
        });

        jLabel7.setText("Platos");

        jLabel8.setText("jLabel6");

        javax.swing.GroupLayout platosLayout = new javax.swing.GroupLayout(platos);
        platos.setLayout(platosLayout);
        platosLayout.setHorizontalGroup(
            platosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(platosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        platosLayout.setVerticalGroup(
            platosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(platosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(platosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProveedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProveedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProveedorMouseExited(evt);
            }
        });

        jLabel9.setText("Proveedor");

        jLabel10.setText("jLabel6");

        javax.swing.GroupLayout ProveedorLayout = new javax.swing.GroupLayout(Proveedor);
        Proveedor.setLayout(ProveedorLayout);
        ProveedorLayout.setHorizontalGroup(
            ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        ProveedorLayout.setVerticalGroup(
            ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_opcionesLayout = new javax.swing.GroupLayout(panel_opciones);
        panel_opciones.setLayout(panel_opcionesLayout);
        panel_opcionesLayout.setHorizontalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_opcionesLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(platos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_opcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_opcionesLayout.setVerticalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_opcionesLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(platos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_principal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_adebajoLayout = new javax.swing.GroupLayout(panel_adebajo);
        panel_adebajo.setLayout(panel_adebajoLayout);
        panel_adebajoLayout.setHorizontalGroup(
            panel_adebajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_adebajoLayout.createSequentialGroup()
                .addComponent(panel_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panel_cabecera_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
        );
        panel_adebajoLayout.setVerticalGroup(
            panel_adebajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_adebajoLayout.createSequentialGroup()
                .addComponent(panel_cabecera_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel_adebajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_adebajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_adebajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void trabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadorMouseClicked
        panel_home_trabajador a = new panel_home_trabajador();
        a.setBounds(0, 0, anchoPantalla - panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
        panel_principal.removeAll();
        panel_principal.add(a, BorderLayout.CENTER);
        panel_principal.revalidate();
        panel_principal.repaint();
    }//GEN-LAST:event_trabajadorMouseClicked

    private void trabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadorMouseEntered
        setColor(trabajador);
    }//GEN-LAST:event_trabajadorMouseEntered

    private void trabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadorMouseExited
        resetColor(trabajador);
    }//GEN-LAST:event_trabajadorMouseExited

    private void ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseEntered
        setColor(Cliente);
    }//GEN-LAST:event_ClienteMouseEntered

    private void ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseExited
        resetColor(Cliente);
    }//GEN-LAST:event_ClienteMouseExited

    private void ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseClicked
        Panel_Home_Cliente a = new Panel_Home_Cliente();
        a.setBounds(0, 0, anchoPantalla - panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
        panel_principal.removeAll();
        panel_principal.add(a, BorderLayout.CENTER);
        panel_principal.revalidate();
        panel_principal.repaint();
    }//GEN-LAST:event_ClienteMouseClicked

    private void rSButtonMetro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_rSButtonMetro1MouseClicked

    private void platosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_platosMouseClicked
        Panel_Home_Plato a = new Panel_Home_Plato();
        a.setBounds(0, 0, anchoPantalla - panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
        panel_principal.removeAll();
        panel_principal.add(a, BorderLayout.CENTER);
        panel_principal.revalidate();
        panel_principal.repaint();
    }//GEN-LAST:event_platosMouseClicked

    private void platosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_platosMouseEntered
        setColor(platos);
    }//GEN-LAST:event_platosMouseEntered

    private void platosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_platosMouseExited
        resetColor(platos);
    }//GEN-LAST:event_platosMouseExited

    private void ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedorMouseClicked
        Panel_Home_Proveedor a = new Panel_Home_Proveedor();
        a.setBounds(0, 0, anchoPantalla - panel_opciones.getWidth(), alturaPantalla - panel_cabecera_principal.getHeight());
        panel_principal.removeAll();
        panel_principal.add(a, BorderLayout.CENTER);
        panel_principal.revalidate();
        panel_principal.repaint();
    }//GEN-LAST:event_ProveedorMouseClicked

    private void ProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ProveedorMouseEntered

    private void ProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ProveedorMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_principall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_principall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cliente;
    private javax.swing.JPanel Proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel panel_adebajo;
    public static javax.swing.JPanel panel_cabecera_principal;
    public static javax.swing.JPanel panel_opciones;
    public static javax.swing.JPanel panel_principal;
    private javax.swing.JPanel platos;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private javax.swing.JPanel trabajador;
    // End of variables declaration//GEN-END:variables
}
