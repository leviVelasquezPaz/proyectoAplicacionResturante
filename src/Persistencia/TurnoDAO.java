/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cargo;
import Dominio.Turno;
import Presentacionn.frm_principall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Levi
 */
public class TurnoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frm_principall a;
    public ArrayList<Turno> listaTurno = new ArrayList<Turno>();
    Turno turno;

    public void agregar(Turno t) {
        String texto = " insert into TURNO(`idTurno`, `descripcion`, `horaInicio`, `horaSalida`, `Estado`)values(?,?,?,?,?)";
        try {
            System.out.println("--");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, t.getId_turno());
            ps.setString(2, t.getDescripcion());
            ps.setString(3, t.getHora_Inicio());
            ps.setString(4, t.getHora_salida());
            ps.setString(5, t.getEstado());

            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void modificar(Turno t) {
        String texto = "update cargo set  `descripcion`=?, `horaInicio`=?, `horaSalida`=?,Estado=? `idTurno`=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(2, t.getDescripcion());
            ps.setString(3, t.getHora_Inicio());
            ps.setString(4, t.getHora_salida());
            ps.setString(4, t.getEstado());
            ps.setString(1, t.getId_turno());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("Error inesperado", "fail");
        }
    }

    public void Eliminar(String codigo) {
        String t = "delete from turno where idTurno=?";
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

        texto = "select *from turno ";

        modelo.addColumn("id");
        modelo.addColumn("descripcion");
        modelo.addColumn("Hora incio");
        modelo.addColumn("Hora fin");
        modelo.addColumn("Estado");
        String[] cabecera = new String[12];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("idTurno"));
                cabecera[1] = rs.getString("descripcion");
                cabecera[2] = rs.getString("horaInicio");
                cabecera[3] = rs.getString("horaSalida");
                cabecera[4] = rs.getString("Estado");
                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtenerCodigo() {

        String texto = "select *from turno";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("idTurno");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public void cargarListaTurno() {
        String texto = "select *from turno";

        String idCargo = "";
        String descripcion = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                idCargo = rs.getString("idTurno");
                descripcion = rs.getString("descripcion");
                turno = new Turno(idCargo, descripcion, "", "", "");
                listaTurno.add(turno);
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
    }

    public String devolverIdTurno(String descripcion) {
      String codigo="";
        for (Turno lista : listaTurno) {
            if(lista.getDescripcion().equals(descripcion)){
                codigo=lista.getId_turno();
            }
        }
        return codigo;
    }
    
     public String devolverDescripcionTurno(String codigo) {
      String descripcion="";
        for (Turno lista : listaTurno) {
            if(lista.getId_turno().equals(codigo)){
                descripcion=lista.getDescripcion();
            }
        }
        return descripcion;
    }

}
