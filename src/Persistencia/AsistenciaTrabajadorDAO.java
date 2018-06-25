
package Persistencia;

import Dominio.AsistenciaTrabajador;
import Presentacionn.frm_principall;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author levi
 */
public class AsistenciaTrabajadorDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    public ArrayList<AsistenciaTrabajador> listaAsistenciaTrabajador = new ArrayList<AsistenciaTrabajador>();
    AsistenciaTrabajador asi;
    frm_principall e;
    public void insertar(AsistenciaTrabajador t) {
        String texto = " insert into asistencia_trabajador(`idAsietncia_Trabajador`, `nombre_asistencia`, `dia`, `fecha_inicio`,`fecha_fin`,`estado`)values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, t.getIdAsistenciaTrabajador());
            ps.setString(2, t.getNombreAsistencia());
            ps.setString(3, t.getDia());
            ps.setString(4, t.getFecha_inicio());
            ps.setString(5, t.getFecha_fin());
            ps.setString(6, t.getEstado());
            ps.executeUpdate();
            e.controladorErrores("se agrego corectamente", "check");
        } catch (Exception a) {
            e.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(AsistenciaTrabajador t) {
        String texto = "update asistencia_trabajador set `nombre_asistencia`=?, `dia`=?, `fecha_inicio`=?,`fecha_fin`=?,`estado`=? where `idAsietncia_Trabajador`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, t.getNombreAsistencia());
            ps.setString(2, t.getDia());
            ps.setString(3, t.getFecha_inicio());
            ps.setString(4, t.getFecha_fin());
            ps.setString(5, t.getEstado());
            ps.setString(6, t.getIdAsistenciaTrabajador());
            ps.executeUpdate();
            e.controladorErrores("se modifico corectamente", "check");

        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String IdAsistenciaTrabajador) {
        String t = "delete from asistencia_trabajador where idAsietncia_Trabajador=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setString(1, IdAsistenciaTrabajador);
            ps.executeUpdate();
            e.controladorErrores("se elimino correctamente", "check");
        } catch (Exception a) {
            e.controladorErrores("Error al eliminar", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";
        texto = "select *from asistencia_trabajador ";

        modelo.addColumn("Id ");
        modelo.addColumn("Nombre Asistencia");
        modelo.addColumn("Dia");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Fin");
        modelo.addColumn("Estado");

        String[] cabecera = new String[8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("idAsietncia_Trabajador");
                cabecera[1] = rs.getString("nombre_asistencia");
                cabecera[2] = rs.getString("dia");
                cabecera[3] = rs.getString("fecha_inicio");
                cabecera[4] = rs.getString("fecha_fin");
                cabecera[5] = rs.getString("estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception a) {
            e.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public void datosAsistenciaTrabajador() {
        String texto = "select *from asistencia_trabajador";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                String id = rs.getString("idAsietncia_Trabajador");
                String nombreAsistencia = rs.getString("nombre_asistencia");
                String dia = rs.getString("dia");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFin = rs.getString("fecha_fin");
                String estado = rs.getString("estado");

                asi = new AsistenciaTrabajador(nombreAsistencia, nombreAsistencia, dia, fechaInicio, fechaFin, estado);
                listaAsistenciaTrabajador.add(asi);
            }

        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
    }

    public DefaultTableModel buscarPorFecha(String fech) {
        DefaultTableModel modelo = new DefaultTableModel();

        String texto = "SELECT * FROM asistencia_trabajador where fecha_Inicio like '" + fech + "' or fecha_fin like '" + fech + "' ";
        modelo.addColumn("idAsietncia_Trabajador ");
        modelo.addColumn("nombre_asistencia ");
        modelo.addColumn("dia");
        modelo.addColumn("fecha_inicio ");
        modelo.addColumn("fecha_fin ");
        modelo.addColumn("estado");

        String[] cabecera = new String[8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("idAsietncia_Trabajador ");
                cabecera[1] = rs.getString("nombre_asistencia ");
                cabecera[2] = rs.getString("dia");
                cabecera[3] = rs.getString("fecha_inicio");
                cabecera[4] = rs.getString("fecha_fin ");
                cabecera[5] = rs.getString("estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception a) {
            e.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }
    
    public int obtenerCodigo() {

        String texto = "select *from asistencia_trabajador";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idAsietncia_Trabajador");
                e.controladorErrores("id actualizado", "check");
            }
        } catch (Exception a) {
            e.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }
}
