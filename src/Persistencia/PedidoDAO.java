/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cliente;
import Dominio.Pedido;
import Dominio.Trabajador;
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
public class PedidoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Pedido pedido;

    public void agregar(Pedido p) {
        String texto = " insert into pedido(`idPedido`, `idCliente`, `idMesa`, `Fecha`, `Estado`)values(?,?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getId_pedido());
            ps.setString(2, p.getId_cliente());
            ps.setString(3, p.getId_mesa());
            ps.setDate(4, p.getFecha());
            ps.setString(5, p.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Pedido p) {
        String texto = "update pedido set  `idCliente`=?, `idMesa`=?, `Fecha`=?, `Estado`=? where `idPedido`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(2, p.getId_cliente());
            ps.setString(3, p.getId_mesa());
            ps.setDate(4, p.getFecha());
            ps.setString(5, p.getEstado());

            ps.setString(1, p.getId_pedido());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from pedido where idPedido=? ";
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

        texto = "select *from pedido ";

        int ultimoCodigo = 0;
        modelo.addColumn("idPedio");
        modelo.addColumn("idCliente");
        modelo.addColumn("idMesa");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");

        String[] cabecera = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("idPedido");
                cabecera[1] = rs.getString("idCliente");
                cabecera[2] = rs.getString("idMesa");
                cabecera[3] = rs.getString("Fecha");
                cabecera[4] = rs.getString("Estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from pedido";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idPedido");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}
