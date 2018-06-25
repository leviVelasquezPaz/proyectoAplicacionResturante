/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.PedidoPlato;
import Dominio.Pedido_bebida;
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
public class Pedido_bebidaDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Pedido_bebida pedido;

    public void agregar(Pedido_bebida pb) {
        String texto = " insert into pedidobebida(`idPedidoBebida`, `idBebida`, `idPedido`, `cantidad`, `Estado`)values(?,?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, pb.getId_pedido_bebida());
            ps.setString(2, pb.getId_bebida());
            ps.setString(3, pb.getId_pedido());
            ps.setInt(4, pb.getCantidad());
            ps.setString(5, pb.getEstado());

            ps.executeUpdate();
//            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
//            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Pedido_bebida pb) {
        String texto = "update pedidobebida set  `idBebida`=?, `idPedido`=?, `cantidad`=?, `Estado`=? where `idPedidoBebida`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, pb.getId_bebida());
            ps.setString(2, pb.getId_pedido());
            ps.setInt(3, pb.getCantidad());
            ps.setString(4, pb.getEstado());
            ps.setString(5, pb.getId_pedido_bebida());

            ps.executeUpdate();
//            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
//            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from pedidobebida where idPedidoBebida=? ";
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

        texto = "select *from pedidobebida  pb inner join bebida be on pb.idBebida=be.idBebida inner join pedido ped on pb.idPedido=ped.idPedido";

        int ultimoCodigo = 0;
        modelo.addColumn("idPedidoBebida");
        modelo.addColumn("idBebida");
        modelo.addColumn("idPedido");
        modelo.addColumn("cantidad");
        modelo.addColumn("Estado");

        String[] cabecera = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("pb.idPedidoBebida");
                cabecera[1] = rs.getString("be.idBebida");
                cabecera[2] = rs.getString("ped.idPedido");
                cabecera[3] = rs.getString("pb.cantidad");
                cabecera[4] = rs.getString("pb.Estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from pedidobebida";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idPedidoBebida");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}
