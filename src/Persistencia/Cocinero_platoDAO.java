/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cocinero_plato;
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
public class Cocinero_platoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Cocinero_plato cocinero;

    public void agregar(Cocinero_plato c) {
        String texto = " insert into cocinero_plato(`id_cocinero_plato`, `id_plato`, `estado`)values(?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, c.getId_cocinero_plato());
            ps.setString(2, c.getId_plato());
            ps.setString(3, c.getEstado());

            ps.executeUpdate();
//            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
//            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Cocinero_plato c) {
        String texto = "update cocinero_plato set `id_plato`=?, `estado`=? where `id_cocinero_plato`=?  ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, c.getId_plato());
            ps.setString(2, c.getEstado());
            ps.setString(3, c.getId_cocinero_plato());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(int codigo) {
        String t = "delete from cocinero_plato where id_cocinero_plato=?";
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

        texto = "select *from cocinero_plato ";

        int ultimoCodigo = 0;
        modelo.addColumn("id_cocinero_plato");
        modelo.addColumn("id_plato");
        modelo.addColumn("estado");

        modelo.addColumn("estado");
        String[] cabecera = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("id_cocinero_plato");
                cabecera[1] = rs.getString("id_plato");
                cabecera[2] = rs.getString("estado");

                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from cocinero_plato";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_cocinero_plato");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}
