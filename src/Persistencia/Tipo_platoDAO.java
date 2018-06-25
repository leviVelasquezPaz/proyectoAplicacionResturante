/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.PedidoPlato;
import Dominio.Plato;
import Dominio.Tipo_plato;
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
public class Tipo_platoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Tipo_plato plato;
    public ArrayList<Tipo_plato> listaPlato = new ArrayList<Tipo_plato>();

    public void agregar(Tipo_plato pl) {
        String texto = " insert into tipo_plato(`id_tipo_plato`, `nombre`, `estado`)values(?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, pl.getId_Tipo_plato());
            ps.setString(2, pl.getNombre());
            ps.setString(3, pl.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Tipo_plato pl) {
        String texto = "update tipo_plato set  `nombre`=?, `estado`=? where `id_tipo_plato`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, pl.getNombre());
            ps.setString(2, pl.getEstado());
            ps.setString(3, pl.getId_Tipo_plato());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from tipo_plato where id_tipo_plato=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setString(1, codigo);
            ps.executeUpdate();
            a.controladorErrores("se elimino correctamente", "check");
        } catch (Exception e) {
            a.controladorErrores("Error al eliminar", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from tipo_plato";

        modelo.addColumn("id_tipo_plato");
        modelo.addColumn("nombre");
        modelo.addColumn("estado");

        String[] cabecera = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("id_tipo_plato");
                cabecera[1] = rs.getString("nombre");
                cabecera[2] = rs.getString("estado");

                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from tipo_plato";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_tipo_plato");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public void cargarLisaTipoPlato() {
        String texto = "select *from tipo_plato";
        Tipo_plato tipoPlato;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                String codigo = rs.getString("id_tipo_plato");
                String nombre = rs.getString("nombre");
                tipoPlato = new Tipo_plato(codigo, nombre, "");
                listaPlato.add(tipoPlato);
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
    }

    public String obtenerCodigoTipoPlato(String nombre) {
        String codigo = "";

        for (Tipo_plato lista : listaPlato) {
            if (lista.getNombre().equals(nombre)) {
                codigo = lista.getId_Tipo_plato();
            }
        }
        return codigo;
    }

    public String obtenerNombreTipoPlato(String codigo) {
        String nombre = "";

        for (Tipo_plato lista : listaPlato) {
            if (lista.getId_Tipo_plato().equals(codigo)) {
                nombre = lista.getNombre();
            }
        }
        return nombre;
    }
}
