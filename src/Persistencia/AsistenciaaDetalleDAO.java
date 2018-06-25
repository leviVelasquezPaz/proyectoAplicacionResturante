/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.AsisteciaDetalle;
import Dominio.AsistenciaTrabajador;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.Date;
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
public class AsistenciaaDetalleDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    public ArrayList<AsisteciaDetalle> listaAsistenciaDetalle = new ArrayList<AsisteciaDetalle>();
    AsisteciaDetalle detalle;
    frm_principall e;

    public void insertar(AsisteciaDetalle d) {

        String texto = " insert into AsisteciaDetalle(`idTipoBebida`, `idPedido`, `idPedidoBebida`, `descripcion`, `cantidad`, `Estado`)values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, d.getIdAsistencia());
            ps.setString(2, d.getIdAsistenciaTrabajador());
            ps.setString(3, d.getId_trabajador());
            ps.setString(4, d.getHora_llegada());
            ps.setString(5, d.getFecha());
            ps.setString(6, d.getEstado());
            ps.executeUpdate();
            e.controladorErrores("se agrego corectamente", "check");
        } catch (Exception a) {
            e.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(AsisteciaDetalle d) {
        String texto = "update   AsisteciaDetalle set `idAsietncia_Trabajador`=?, `idTrabajador`=?, `hora_llegada`=? ,`fecha`=?, `estado`=?  where `id_Asistencia`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(2, d.getIdAsistenciaTrabajador());
            ps.setString(3, d.getId_trabajador());
            ps.setString(4, d.getHora_llegada());
            ps.setString(5, d.getFecha());
            ps.setString(6, d.getEstado());
            ps.setString(1, d.getIdAsistencia());
            ps.executeUpdate();
            e.controladorErrores("se modifico corectamente", "check");

        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from AsisteciaDetalle where id_Asistencia=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setString(1, codigo);
            ps.executeUpdate();
            e.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception a) {
            e.controladorErrores("Error al eliminar", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = " select * from asistencia_trabajador asit inner join trabajador tra on tra.idTrabajador=tra.idTrabajador ";
        modelo.addColumn("Id Asistencia");
        modelo.addColumn("Id Asistencia Trabajador ");
        modelo.addColumn("Id Trabajador");
        modelo.addColumn("Hora Llegada");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");

        String[] cabecera = new String[8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("asitid_Asistencia");
                cabecera[1] = rs.getString("asitidAsietncia_Trabajador");
                String nombre = rs.getString("tra.nombre");
                String paterno = rs.getString("tra.paterno");
                String materno = rs.getString("tra.materno");
                cabecera[2] = nombre + " " + paterno+" "+materno;
                cabecera[3] = rs.getString(" hora_llegada");
                cabecera[4] = rs.getString("fecha");
                cabecera[5] = rs.getString("estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception a) {
            e.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public void datosAsistenciaTrabajador() {
        String texto = "select *from AsisteciaDetalle";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                String idAsistencia = rs.getString("id_Asistencia");
                String idAsistenciaTrabajador = rs.getString("idAsietncia_Trabajador");
                String idTrabajador = rs.getString("idTrabajador");
                String horaLlegada = rs.getString("hora_llegada");
                String fecha = rs.getString("fecha");
                String estado = rs.getString("estado");
                detalle = new AsisteciaDetalle(idAsistencia, idAsistenciaTrabajador, idTrabajador, estado, fecha, estado);
                listaAsistenciaDetalle.add(detalle);
            }

        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
    }

    public int obtenerCodigo() {
        String texto = "select *from asistencia_detalle";

        int codigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                codigo = rs.getInt("id_Asistencia");
            }
        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
        return codigo + 1;
    }

}
