package Persistencia;

import Dominio.AsistenciaTrabajador;
import Dominio.Proveedor;
import Presentacionn.frm_principall;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProveedorDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    public ArrayList<Proveedor> listaAsistenciaTrabajador = new ArrayList<Proveedor>();
    Proveedor proveedor;
    frm_principall e;

    public void insertar(Proveedor p) throws IOException {
        String sql = "insert into almacen(id_proveedor,nombre,a_paterno, a_materno, dni, telefono, direccion, e_mail, estado) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, p.getId_proveedor());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getA_paterno());
            ps.setString(4, p.getA_materno());
            ps.setInt(5, p.getDNI());
            ps.setInt(6, p.getTelefono());
            ps.setString(7, p.getDireccion());
            ps.setString(8, p.getE_mail());
            ps.setString(9, p.getEstado());
            ps.executeUpdate();
            e.controladorErrores("se agrego corectamente", "check");
        } catch (Exception a) {
            e.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Proveedor p) {
        String texto = "update  set proveedor `nombre`=?, `a_paterno`=?, `a_materno`=? ,`dni`=?, `telefono`=? , `direccion`=?, `direccion`=?, `estado`=?,where `id_proveedor`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getId_proveedor());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getA_paterno());
            ps.setString(4, p.getA_materno());
            ps.setInt(5, p.getDNI());
            ps.setInt(6, p.getTelefono());
            ps.setString(7, p.getDireccion());
            ps.setString(8, p.getE_mail());
            ps.setString(9, p.getEstado());
            ps.executeUpdate();
            e.controladorErrores("se modifico corectamente", "check");

        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String idProveedor) {
        String t = "delete from proveedor where idProveedor=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setString(1, idProveedor);
            ps.executeUpdate();
            e.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception a) {
            e.controladorErrores("Error al eliminar", "fail");
        }
    }
//public DefaultTableModel mostrar() {
//        DefaultTableModel modelo = new DefaultTableModel();
//        String texto = "";
//
//        texto = "select *from proveedor ";
//
//        modelo.addColumn("id proveedor");
//        modelo.addColumn("Nombre ");
//        modelo.addColumn("Apellido Paterno");
//        modelo.addColumn("Apellido Materno");
//        modelo.addColumn("DNI");
//        modelo.addColumn("Teléfono");
//        modelo.addColumn("Dirección");
//        modelo.addColumn("Email");
//        modelo.addColumn("Estado");
//
//        String[] cabecera = new String[12];
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(texto);
//            while (rs.next()) {
//                cabecera[0] = rs.getString("idAsietncia_Trabajador");
//                cabecera[1] = rs.getString("nombre_asistencia ");
//                cabecera[2] = rs.getString("dia");
//                cabecera[3] = rs.getString("dia");
//                cabecera[4] = rs.getString("dia");
//                cabecera[5] = rs.getString("dia");
//                cabecera[6] = rs.getString("fecha_inicio ");
//                cabecera[7] = rs.getString("fecha_fin ");
//                cabecera[8] = rs.getString("estado");
//                modelo.addRow(cabecera);
//
//            }
//        } catch (Exception a) {
//            e.controladorErrores("ocurrio un error inesperado", "fail");
//        }
//        return modelo;
//    }

    public static String Id_proveedor = "";
    public static String Nombre = "";
    public static String A_paterno = "";
    public static String A_materno = "";
    public static int DNI;
    public static int telefono;
    public static String direccion = "";
    public static String E_mail = "";
    public static String estado = "";

    public static void verDatoScliene(Presentacion.Proveedor.Panel_Ver_Datos_Proveedor ver, String codigo) {
        Connection cn = Conexion.conexion();
        int c = 0;
        String SsQL = " Select * from Proveedor where id_proveedor=" + codigo;
        try {
            Statement ps = cn.createStatement();
            ResultSet r = ps.executeQuery(SsQL);

            if (r.next()) {
                c = r.getInt(1);
                ProveedorDAO.Id_proveedor = r.getString(1);
                ProveedorDAO.Nombre = r.getString(2);
                ProveedorDAO.A_paterno = r.getString(3);
                ProveedorDAO.A_materno = r.getString(4);
                ProveedorDAO.DNI = r.getInt(5);
                ProveedorDAO.telefono = r.getInt(6);
                ProveedorDAO.direccion = r.getString(7);
                ProveedorDAO.E_mail = r.getString(8);
                ProveedorDAO.estado = r.getString(9);

            }
            ver.limpiarLables();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos" + e.getMessage());
        }
    }
}
