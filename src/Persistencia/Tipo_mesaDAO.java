/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Tipo_mesa;
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
public class Tipo_mesaDAO {
       private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Tipo_mesa mesa;

    public void agregar(Tipo_mesa me) {
        String texto = " insert into tipomesa(`id_tipo_mesa`, `descripcion`, `estado`)values(?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, me.getId_tipo_de_mesa());
            ps.setString(2, me.getDescripcion());
            ps.setString(3, me.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Tipo_mesa me) {
        String texto = "update tipomesa set  `descripcion`=?, `estado`=? where `id_tipo_mesa`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, me.getDescripcion());
            ps.setString(2, me.getEstado());
            ps.setString(3, me.getId_tipo_de_mesa());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from tipomesa where id_tipo_mesa =? ";
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

        texto = "select *from tipomesa";

        modelo.addColumn("id_tipo_mesa");
        modelo.addColumn("descripcion");
        modelo.addColumn("estado");

        String[] cabecera = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("id_tipo_mesa");
                cabecera[1] = rs.getString("descripcion");
                cabecera[2] = rs.getString("estado");

                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from tipomesa";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_tipo_mesa");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}


