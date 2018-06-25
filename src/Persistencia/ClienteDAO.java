/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cliente;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.Date;
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
public class ClienteDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    public ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    Cliente cliente;

    public void agregar(Cliente p) {
        String texto = "insert into cliente(`idCliente`, `nombres`, `a_paterno`, `a_materno`, `sexo`, `direcion`, `correo`, `dni`, `telefono`, `estado`)values(?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getIdCliente());
            ps.setString(2, p.getNombres());
            ps.setString(3, p.getA_pateno());
            ps.setString(4, p.getA_materno());
            ps.setString(5, p.getSexo());
            ps.setString(6, p.getDirecion());
            ps.setString(7, p.getCorreo());
            ps.setInt(8, p.getDni());
            ps.setString(9, p.getTelefono());
            ps.setString(10, p.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Cliente p) {
        String texto = "update cliente set  `nombres`=?, `a_paterno`=?, `a_materno`=?, `sexo`=?, `direcion`=?, `correo`=?, `dni`=?, `telefono`=?, `estado`=? where `idCliente`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getA_pateno());
            ps.setString(3, p.getA_materno());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getDirecion());
            ps.setString(6, p.getCorreo());
            ps.setInt(7, p.getDni());
            ps.setString(8, p.getTelefono());
            ps.setString(9, p.getEstado());
            ps.setString(10, p.getIdCliente());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from cliente where idCliente=?";
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

        texto = "select *from cliente ";

        int ultimoCodigo = 0;
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Paterno");
        modelo.addColumn("MAterno");
        modelo.addColumn("Sexo");
        modelo.addColumn("direcion");
        modelo.addColumn("correo");
        modelo.addColumn("dni");
        modelo.addColumn("telefono ");

        modelo.addColumn("estado");
        String[] cabecera = new String[12];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("idCliente");
                cabecera[1] = rs.getString("nombres");
                cabecera[2] = rs.getString("a_paterno");
                cabecera[3] = rs.getString("a_materno");
                cabecera[4] = rs.getString("sexo");
                cabecera[5] = rs.getString("direcion");
                cabecera[6] = rs.getString("correo");
                cabecera[7] = String.valueOf(rs.getInt("dni"));
                cabecera[8] = rs.getString("telefono");
                cabecera[9] = rs.getString("estado");

                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return modelo;
    }

    public void cargarDatosClientes() {
        String texto = "select *from cliente";

        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                int id = rs.getInt("idCliente");
                String nombre = rs.getString("nombres");
                String paterno = rs.getString("a_paterno");
                String materno = rs.getString("a_materno");
                String sexo = rs.getString("sexo");
                String direccion = rs.getString("direcion");
                String correo = rs.getString("correo");
                int dni = rs.getInt("dni");
                String telefono = rs.getString("telefono");
                String estado = rs.getString("estado");
                cliente = new Cliente(direccion, nombre, paterno, materno, sexo, direccion, correo, dni, telefono, estado);
                listaClientes.add(cliente);
            }

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }
    public static int paso = 1;
    public static String idCliente;
    public static String nombres;
    public static String A_pateno;
    public static String A_materno;
    public static String sexo;
    public static String direcion;
    public static String correo;
    public static int dni;
    public static String telefono;
    public static String estado;

    public static void verDatoScliene(Presentacion.Cliente.Panel_Ver_Clientes ver, String codigo) {
        Connection cn = Conexion.conexion();
        int c = 0;
        String SsQL = " Select * from Cliente where idCliente=" + codigo;
        try {
            Statement ps = cn.createStatement();
            ResultSet r = ps.executeQuery(SsQL);

            if (r.next()) {
                c = r.getInt(1);
                ClienteDAO.idCliente = r.getString(1);
                ClienteDAO.nombres = r.getString(2);
                ClienteDAO.A_pateno = r.getString(3);
                ClienteDAO.A_materno = r.getString(4);
                ClienteDAO.sexo = r.getString(5);
                ClienteDAO.direcion = r.getString(6);
                ClienteDAO.correo = r.getString(7);
                ClienteDAO.dni = r.getInt(8);
                ClienteDAO.telefono = r.getString(9);
                ClienteDAO.estado = r.getString(10);

            }
            ver.limpiarLabelsVista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos");
        }
    }

    public int obtenerCodigo() {
        String SsQL = " Select *from Cliente ";
        int codigo = -1;
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(SsQL);

            if (rs.next()) {
                codigo = rs.getInt("idCliente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos");
        }
        return codigo+ 1;

    }
}
