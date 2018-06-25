/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Tipo_bebida;
import Dominio.Tipo_plato;
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
public class Tipo_bebidaDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Tipo_bebida bebida;

    public void agregar(Tipo_bebida be) {
        String texto = " insert into tipobebida(`idTipoBebida`, `idPedido`, `idPedidoBebida`, `descripcion`, `cantidad`, `Estado`)values(?,?,?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, be.getId_tipoBebida());
            ps.setString(2, be.getId_pedido());
            ps.setString(3, be.getId_pedidoBebida());
            ps.setString(4, be.getDescripcion());
            ps.setInt(5, be.getCantidad());
            ps.setString(6, be.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Tipo_bebida be) {
        String texto = "update tipobebida  set  `idPedido`=?, `idPedidoBebida`=?, `descripcion`=? , `cantidad`=?, `Estado`=?  where `idTipoBebida`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, be.getId_pedido());
            ps.setString(2, be.getId_pedidoBebida());
            ps.setString(3, be.getDescripcion());
            ps.setInt(4, be.getCantidad());
            ps.setString(5, be.getEstado());
            ps.setString(6, be.getId_tipoBebida());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from tipobebida where idTipoBebida=? ";
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

       texto = "select *from tipobebida Tb inner join pedido pe on  Tb.idPedido=pe.idPedido   inner join pedidobebida pb  on Tb.idPedidoBebida=pb.idPedidoBebida";

        modelo.addColumn("idTipoBebida");
        modelo.addColumn("idPedido");
        modelo.addColumn("idPedidoBebida");
        modelo.addColumn("descripcion");
        modelo.addColumn("cantidad");
        modelo.addColumn("Estado");

        String[] cabecera = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("idTipoBebida");
                cabecera[1] = rs.getString("idPedido");
                cabecera[2] = rs.getString("idPedidoBebida");
                cabecera[3] = rs.getString("descripcion");
                cabecera[4] = rs.getString("cantidad");
                cabecera[5] = rs.getString("Estado");
                
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from tipobebida";

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
