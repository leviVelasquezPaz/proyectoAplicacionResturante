/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Insumo_bebida;
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
public class Insumo_bebidaDAO {
     private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Insumo_bebida insumo;

    public void agregar(Insumo_bebida in) {
        String texto = " insert into insumos_bebida(`id_insumo_bebida`, `idBebida`, `id_insumo`, `estado`)values(?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, in.getId_Isumo_bebida());
            ps.setString(2, in.getId_bebida());
            ps.setString(3, in.getId_insumo());
            ps.setString(4, in.getEstado());
            

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Insumo_bebida in) {
        String texto = "update pedidoplato set  `idBebida`=?, `id_insumo`=?, `estado`=? where `id_insumo_bebida`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, in.getId_bebida());
            ps.setString(2, in.getId_insumo());
            ps.setString(3, in.getEstado());
            ps.setString(4, in.getId_Isumo_bebida());
            

            ps.executeUpdate();
           a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
           a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from insumos_bebida id_insumo_bebida where =? ";
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

        texto = "select *from insumos_bebida Ib inner join bebida be on  Ib.idBebida=be.idBebida inner join insumo in on Ib.id_insumo=in.id_insumo";

        modelo.addColumn("id_insumo_bebida");
        modelo.addColumn("idBebida");
        modelo.addColumn("id_insumo");
        modelo.addColumn("estado");
      

        String[] cabecera = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("Ib.id_insumo_bebida");
                cabecera[1] = rs.getString("be.idBebida");
                cabecera[2] = rs.getString("in.id_insumo");
                cabecera[3] = rs.getString("Ib.estado");
               
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from insumos_bebida";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_insumo_bebida");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}


