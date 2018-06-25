/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Pedido;
import Dominio.PedidoPlato;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PedidoPlatoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    PedidoPlato pedido;

    public void agregar(PedidoPlato p) {
        String texto = " insert into pedidoplato(`id_pedido_plata`, `idPedido`, `id_plato`, `cantidad`, `estado`)values(?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getId_Pedido_Plato());
            ps.setString(2, p.getId_pedido());
            ps.setString(3, p.getId_plato());
            ps.setString(4, p.getCantidad());
            ps.setString(5, p.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(PedidoPlato p) {
        String texto = "update pedidoplato set  `idPedido`=?, `id_plato`=?, `cantidad`=?, `estado`=? where `id_pedido_plata`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, p.getId_pedido());
            ps.setString(2, p.getId_plato());
            ps.setString(3, p.getCantidad());
            ps.setString(4, p.getEstado());
            ps.setString(5, p.getId_Pedido_Plato());

            ps.executeUpdate();
           a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
           a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from pedidoplato where id_pedido_plata=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setString(1, codigo);
            ps.executeUpdate();
            a.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception e) {
            a.controladorErrores("Error al eliminar", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from pedidoplato Pp inner join pedido pe on Pp.idPedido=pe.idPedido inner join plato pla on Pp.id_plato=pla.id_plato";

        modelo.addColumn("id_pedido_plata");
        modelo.addColumn("idPedido");
        modelo.addColumn("id_plato");
        modelo.addColumn("cantidad");
        modelo.addColumn("Estado");

        String[] cabecera = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("Pp.id_pedido_plata");
                cabecera[1] = rs.getString("pe.idPedido");
                cabecera[2] = rs.getString("pla.id_plato");
                cabecera[3] = rs.getString("Pp.cantidad");
                cabecera[4] = rs.getString("Pp.Estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from pedidoplato";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_pedido_plata");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}
