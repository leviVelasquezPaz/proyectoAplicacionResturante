/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.PedidoPlato;
import Dominio.Trabajador;
import Dominio.Venta;
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
public class VentaDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Venta venta;

    public void agregar(Venta v) {
        String texto = " insert into ventas(`idVentas`, `idPedido`, `estado`)values(?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, v.getIdVenta());
            ps.setString(2, v.getId_pedido());
            ps.setString(3, v.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Venta v) {
        String texto = "update ventas set  `idPedido`=?, `estado`=? where `idVentas`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, v.getId_pedido());
            ps.setString(2, v.getEstado());
            ps.setString(3, v.getIdVenta());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from ventas where idVentas=?  ";
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

        texto = "select ven.idVentas,ped.idPedido,ven.estado from ventas ven inner join pedido ped on ven.idPedido=ped.idPedido";

        modelo.addColumn("idVentas");
        modelo.addColumn("idPedido");
        modelo.addColumn("estado");
     

        String[] cabecera = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("ven.id_pedido_plata");
                cabecera[1] = rs.getString("ped.idPedido");
                cabecera[2] = rs.getString("ven.id_plato");
                
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from ventas";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idVentas");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}
