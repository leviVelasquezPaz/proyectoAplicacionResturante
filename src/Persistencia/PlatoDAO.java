/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Bebida;
import Dominio.Cliente;
import Dominio.Plato;
import Dominio.Tipo_plato;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author levi
 */
public class PlatoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;

    public ArrayList<Plato> listaPlato = new ArrayList<Plato>();
    Plato plato;
    frm_principall a;
    public ArrayList<Tipo_plato> listaTipoPlato = new ArrayList<Tipo_plato>();

    public void agregar(Plato p) {
        String texto = "insert into plato(`id_plato`, `id_tipo_plato`, `nombre`, `precio_venta`, `imagen`, `estado`)values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getId_plato());
            ps.setString(2, p.getId_tipoPlato());
            ps.setString(3, p.getNombre());
            ps.setDouble(4, p.getPrecioVenta());
            ps.setString(5, p.getImagen());
            ps.setString(6, p.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public Plato buscarPlato(String idPlato) throws SQLException {

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        Plato pla = null;

        try {
            ps1 = cn.prepareStatement("SELECT * FROM plato WHERE nombre like '" + idPlato + "'");

            ps1.setString(1, idPlato);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                String idTipoPlato = rs.getString("id_plato");
                String nombre = rs.getString("nombre");
                String id_tipo_plato = rs.getString("id_tipo_plato");
                double precioVenta = rs.getDouble("precio_venta");
                String estado = rs.getString("estado");
                String imagen = rs.getString("imagen");
                pla = new Plato(idPlato, idTipoPlato, nombre, precioVenta, imagen, estado);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cn.close();
            ps1.close();

        }
        return pla;
    }

    public void modificar(Plato p) {

        String texto = "update plato set  `id_tipo_plato`=?, `nombre`=?, `precio_venta`=?, `imagen`=?,`estado`=? where `id_plato`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getId_tipoPlato());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecioVenta());
            ps.setString(4, p.getImagen());
            ps.setString(5, p.getEstado());
            ps.setString(6, p.getId_plato());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String idPlato) {
        String t = "delete from plato where id_plato=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setString(1, idPlato);
            ps.executeUpdate();
            a.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception e) {
            a.controladorErrores("Error al eliminar", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";
        texto = "select *from plato p inner join tipo_plato tp on p.id_tipo_plato=tp.id_tipo_plato ";
        modelo.addColumn("Id");
        modelo.addColumn("Tipo plato");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Imagen");
        modelo.addColumn("Estado");
        String[] cabecera = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("p.id_plato"));
                cabecera[1] = rs.getString("tp.nombre");
                cabecera[2] = rs.getString("p.nombre");
                cabecera[3] = rs.getString("p.precio_venta");
                cabecera[4] = rs.getString("p.imagen");
                cabecera[5] = rs.getString("p.estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public void cargarDatosPlato() {
        String texto = "select *from plato";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                String idPlato = rs.getString("id_plato");
                String idTipoPlato = rs.getString("id_tipo_plato");
                String nombe = rs.getString("nombre");
                double precioVenta = rs.getDouble("precio_venta");
                String estado = rs.getString("estado");
                String imagen = rs.getString("imagen");
                plato = new Plato(idPlato, idTipoPlato, nombe, precioVenta, imagen, estado);
                listaPlato.add(plato);
            }

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public int obtenerId() {
        String texto = "select *from plato";
        String codigo = "0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                codigo = rs.getString("id_plato");
                JOptionPane.showMessageDialog(null, "codigo");
            }
        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
        return Integer.parseInt(codigo) + 1;
    }

}
