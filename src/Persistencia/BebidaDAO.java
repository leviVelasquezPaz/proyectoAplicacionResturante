/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cliente;
import Dominio.Bebida;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author levi
 */
public class BebidaDAO {
  private Conexion con = new Conexion();
  private Connection cn = con.conexion();
  DefaultTableModel modelo;
   public ArrayList<Bebida> listaBebida = new ArrayList<Bebida>();
   Bebida bebida;
    frm_principall e;
   
      
   public void agregar(Bebida b) {
        String texto = " insert into bebida(`Id_bebida`, `Id_tipoBebida`, `Nombre_bebida`, `PrecioVenta`,`estado`)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            
            ps.setString(1, b.getId_bebida());
            ps.setString(2, b.getId_tipoBebida());
            ps.setString(3, b.getNombre_bebida());
            ps.setDouble(4, b.getPrecioVenta());
            ps.setString(5, b.getEstado());
            ps.executeUpdate();
             e.controladorErrores("se agrego corectamente", "check");
        } catch (Exception a) {
             e.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }
   
   
   
    public void modificar(Bebida p) {
        String texto = "update bebida set  `Id_tipoBebida`=?, `Nombre_bebida`=?, `PrecioVenta`=?, `estado`=? where `Id_bebida`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(2, p.getId_tipoBebida());
            ps.setString(3, p.getNombre_bebida());
            ps.setDouble(4, p.getPrecioVenta());
            ps.setString(5, p.getEstado());
            ps.setString(1, p.getId_bebida());
            ps.executeUpdate();
            e.controladorErrores("se modifico corectamente", "check");

        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
    }
    public void Eliminar(String idBebida) {
        String t = "delete from bebida where idBebida=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setString(1, idBebida);
            ps.executeUpdate();
            e.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception a) {
            e.controladorErrores("Error al eliminar", "fail");
        }
    }
 public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from bebida ";

        modelo.addColumn("Id Bebida");
        modelo.addColumn("Id Tipo Bebida");
        modelo.addColumn("Nombre Bebida");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Estado");
       
        String[] cabecera = new String[8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id_bebida"));
                cabecera[1] = rs.getString("Id TipoBebida");
                cabecera[2] = rs.getString("NombreBebida");
                cabecera[3] = rs.getString("precioVenta");
                cabecera[4] = rs.getString("estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception a) {
            e.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }
  public void cargarDatosBebida() {
        String texto = "select *from bebida";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                 String id = rs.getString("idBebida");
                String tipobebida = rs.getString("idTipoBebida");
                String nombeBebida = rs.getString("NombreBibida");
                double precioVenta = rs.getDouble("precioVenta");
                String estado = rs.getString("estado");
                
                bebida=new Bebida(id,tipobebida, nombeBebida, precioVenta, estado);
                listaBebida.add(bebida);
                
            }

        } catch (Exception a) {
            e.controladorErrores("Error inesperado", "fail");
        }
  }
}
