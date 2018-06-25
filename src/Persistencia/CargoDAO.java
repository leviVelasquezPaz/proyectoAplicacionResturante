/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cargo;
import Dominio.Cliente;
import Dominio.Trabajador;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CargoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Cargo cargo;

    public ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();

    public void agregar(Cargo t) {
        String texto = " insert into cargo(`idCargo`, `NombreCargo`, `sueldo`, `Estado`)values(?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, t.getId_cargo());
            ps.setString(2, t.getNombre_de_cargo());
            ps.setDouble(3, t.getSueldo());
            ps.setString(4, t.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Cargo t) {
        String texto = "update cargo set  `idCargo`=?, `NombreCargo`=?, `sueldo`=?, `Estado`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, t.getId_cargo());
            ps.setString(2, t.getNombre_de_cargo());
            ps.setDouble(3, t.getSueldo());
            ps.setString(4, t.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from cargo where idCargo=?";
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

        texto = "select *from cargo ";

        modelo.addColumn("id");
        modelo.addColumn("NombreCargo");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Estado");

        String[] cabecera = new String[12];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("idCargo"));
                cabecera[1] = rs.getString("NombreCargo");
                cabecera[2] = rs.getString("sueldo");
                cabecera[3] = rs.getString("Estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from cargo";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idCargo");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public void cargarListaCargo() {
        String texto = "select *from cargo";

        String idCargo = "";
        String nombre = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                idCargo = rs.getString("idCargo");
                nombre = rs.getString("NombreCargo");
                cargo = new Cargo(idCargo, nombre, 0, "");
                listaCargo.add(cargo);
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
    }

    public String devolverIdCargo(String descripcion) {
       
        cargarListaCargo();
        String codigo = "";
        
        for (Cargo lista : listaCargo) {
            if (lista.getNombre_de_cargo().equals(descripcion)) {
                codigo = lista.getId_cargo();
            }
        }
        return codigo;
    }

    public String devolverDescripcionCargo(String codigo) {
        String descripcion = "";
        for (Cargo lista : listaCargo) {
            if (lista.getId_cargo().equals(codigo)) {
                descripcion = lista.getNombre_de_cargo();
            }
        }
        return descripcion;
    }

}
