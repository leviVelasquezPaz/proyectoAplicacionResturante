/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Insumo_bebida;
import Dominio.Insumo_plato;
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
public class Insumo_platoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Insumo_plato plato;

    public void agregar(Insumo_plato in) {
        String texto = " insert into insumo_plato(`id_insumo_plato`,`id_insumo`, `id_plato`, `estado`)values(?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, in.getId_Insumo_plato());
            ps.setString(2, in.getId_insumo());
            ps.setString(3, in.getId_plato());
            ps.setString(4, in.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Insumo_plato ip) {
        String texto = "update insumo_plato set  `id_insumo`=?, `id_plato`=?, `estado`=? where `id_insumo_plato`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, ip.getId_insumo());
            ps.setString(2, ip.getId_plato());
            ps.setString(3, ip.getEstado());
            ps.setString(4, ip.getId_insumo());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from insumo_plato id_insumo_plato where =? ";
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

        texto = "select *from insumo_plato Ip inner join insumo ins on  Ip.id_insumo=ins.id_insumo   inner join plato pl  on Ip.id_plato=pl.id_plato";

        modelo.addColumn("id_insumo_plato");
        modelo.addColumn("id_insumo");
        modelo.addColumn("id_plato");
        modelo.addColumn("estado");

        String[] cabecera = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("Ip.id_insumo_plato");
                cabecera[1] = rs.getString("ins.id_insumo");
                cabecera[2] = rs.getString("pl.id_plato");
                cabecera[3] = rs.getString("Ib.estado");

                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from insumo_plato";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_insumo_plato");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

}
