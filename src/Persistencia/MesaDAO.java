/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Mesa;
import Dominio.Trabajador;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class MesaDAO {
     private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall m;
    Mesa  mesa;

    public void agregar(Mesa m) {
        String texto = " insert into mesa(`idMesa`, `id_tipo_mesa`, `cantidad_mesa`, `estado`)values(?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, m.getId_mesa());
            ps.setString(2, m.getId_tipo_de_mesa());
            ps.setInt(3, m.getCantidad_En_mesa());
            ps.setString(4, m.getEstado());
            

            ps.executeUpdate();
            // e.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            // e.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Mesa m) {
        String texto = "update mesa set  `id_tipo_mesa`=?, `cantidad_mesa`=?, `estado`=? where `idMesa`=?"  ;
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, m.getId_mesa());
            ps.setString(2, m.getId_tipo_de_mesa());
            ps.setInt(3, m.getCantidad_En_mesa());
            ps.setString(4, m.getEstado());
            
          
            
            ps.executeUpdate();
//            e.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
//            e.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(int codigo) {
        String t = "delete from mesa where idMesa=?";
        try {
            PreparedStatement ps = cn.prepareStatement(t);
            ps.setInt(1, codigo);
            ps.executeUpdate();
           m.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception e) {
           m.controladorErrores("Error al eliminar", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from mesa ";

        modelo.addColumn("idMesa");
        modelo.addColumn("idTipoMesa");
        modelo.addColumn("cantidadMesa");
        modelo.addColumn("Estado");
      

        String[] cabecera = new String[5];
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("idMesa"));
                cabecera[1] = rs.getString("idTipoMesa");
                cabecera[2] = rs.getString("CantidadMesa");
                cabecera[3] = rs.getString("Estado");
               
                modelo.addRow(cabecera);

            }
            m.controladorErrores("Datos Mostrados", "fail");
        } catch (Exception e) {
          m.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

     public int obtenerCodigo() {

        String texto = "select * from mesa";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idMesa");
                m.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            m.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }
 
    }







