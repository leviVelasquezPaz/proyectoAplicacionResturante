/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Trabajador;
import Persistencia.Conexion;
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
 * @author levi
 */
public class TrabajadorDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    Trabajador trabajador;
    public ArrayList<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();

    public void agregar(Trabajador t) {
        String texto = " insert into trabajador(`idTrabajador`, `idCargo`, `idTurno`, `nombre`, `paterno`, `materno`, `DNI`, `genero`, `telefono`, `direccion`, `email`, `estado`)values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, t.getId_trabajador());
            ps.setString(2, t.getId_cargo());
            ps.setString(3, t.getId_turno());
            ps.setString(4, t.getNombre());
            ps.setString(5, t.getA_paterno());
            ps.setString(6, t.getA_materno());
            ps.setInt(7, t.getDNI());
            ps.setString(8, t.getGenero());
            ps.setInt(9, t.getTelefono());
            ps.setString(10, t.getDireccion());
            ps.setString(11, t.getE_mail());
            ps.setString(12, t.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Trabajador t) {
        String texto = "update trabajador set  `idCargo`=?, `idTurno`=?, `nombre`=?, `paterno`=?, `materno`=?, `DNI`=?, `genero`=?, `telefono`=?, `direccion`=?, `email`=?, `estado`=? where `idTrabajador`=? ";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(2, t.getId_cargo());
            ps.setString(3, t.getId_turno());
            ps.setString(4, t.getNombre());
            ps.setString(5, t.getA_paterno());
            ps.setString(6, t.getA_materno());
            ps.setInt(7, t.getDNI());
            ps.setString(8, t.getGenero());
            ps.setInt(9, t.getTelefono());
            ps.setString(10, t.getDireccion());
            ps.setString(11, t.getE_mail());
            ps.setString(12, t.getEstado());
            ps.setString(1, t.getId_trabajador());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from trabajador where idTrabajador=? ";
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

        texto = "select *from trabajador  tra inner join turno tur on tra.idTurno=tur.idTurno inner join cargo car on tra.idCargo=car.idCargo";

        modelo.addColumn("idTrabajador");
        modelo.addColumn("idCargo");
        modelo.addColumn("idTurno");
        modelo.addColumn("Nombre");
        modelo.addColumn("Paterno");
        modelo.addColumn("Materno");
        modelo.addColumn("DNI");
        modelo.addColumn("Genero");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Email");
        modelo.addColumn("Estado");
        String[] cabecera = new String[15];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "algo");
                cabecera[0] = rs.getString("tra.idTrabajador");
                cabecera[1] = rs.getString("car.NombreCargo");
                cabecera[2] = rs.getString("tur.descripcion");
                cabecera[3] = rs.getString("tra.nombre");
                cabecera[4] = rs.getString("tra.paterno");
                cabecera[5] = rs.getString("tra.materno");
                cabecera[6] = rs.getString("tra.DNI");
                cabecera[7] = rs.getString("tra.genero");
                cabecera[8] = rs.getString("tra.telefono");
                cabecera[9] = rs.getString("tra.direccion");
                cabecera[10] = rs.getString("tra.email");
                cabecera[11] = rs.getString("tra.estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from trabajador";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idTrabajador");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public void cargarListaTrabajadores() {

        String texto = "select  *from trabajador";
        Trabajador trabajador;
        String codigo, nombre;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                codigo = rs.getString("idTrabajador");
                nombre = rs.getString("nombre");
                String parterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                trabajador = new Trabajador(codigo, "", "", nombre + " " + parterno + " " + materno, "", "", 0, "", 0, "", "", "");
                listaTrabajadores.add(trabajador);
                System.out.println(trabajador.toString());
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
    }

    public String devolverIdTrabajador(String nombre) {
        String codigo = "";
        for (Trabajador lista : listaTrabajadores) {
            if (lista.getNombre().equals(nombre)) {
                codigo = lista.getId_trabajador();
            }
        }
        return codigo;
    }
    
     public String devolverNombreTrabajador(String codigo) {
        String nombre = "";
        for (Trabajador lista : listaTrabajadores) {
            if (lista.getId_trabajador().equals(codigo)) {
                nombre = lista.getNombre();
            }
        }
        return nombre;
    }

}
