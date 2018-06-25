/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cliente;
import Dominio.Insumo;
import Dominio.Trabajador;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class InsumoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;

    Insumo insumo;

    public void agregar(Insumo i) {
        String texto = " insert into insumo(`id_insumo`, `id_proveedor`, `cantidad`, `estado`)values(?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, i.getId_insumo());
            ps.setString(2, i.getId_proveedor());
            ps.setInt(3, i.getCantidad());
            ps.setString(4, i.getEstado());

            ps.executeUpdate();
//            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
//            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Insumo i) {
        String texto = "update cliente set  `id_proveedor`=?, `cantidad`=?, `estado`=? where `id_insumo`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(2, i.getId_proveedor());
            ps.setInt(3, i.getCantidad());
            ps.setString(4, i.getEstado());
            ps.setString(1, i.getId_insumo());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(int codigo) {
        String t = "delete from insumo where id_insumo=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            a.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception e) {
            a.controladorErrores("Error al eliminar", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from insumo";

        int ultimoCodigo = 0;
        modelo.addColumn("id_insumo");
        modelo.addColumn("id_proveedor");
        modelo.addColumn("cantidad");
        modelo.addColumn("estado");
       
        String[] cabecera = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("id_insumo");
                cabecera[1] = rs.getString("id_proveedor");
                cabecera[2] = rs.getString("cantidad");
                cabecera[3] = rs.getString("estado");
                

                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from insumo";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_insumo");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}
