/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author levi
 */
public class AsistenciaTrabajador {

    private String idAsistenciaTrabajador;
    private String NombreAsistencia;
    private String dia;
    private String fecha_inicio;
    private String fecha_fin;
    private String estado;

    public AsistenciaTrabajador(String idAsistenciaTrabajador, String NombreAsistencia, String dia, String fecha_inicio, String fecha_fin, String estado) {
        this.idAsistenciaTrabajador = idAsistenciaTrabajador;
        this.NombreAsistencia = NombreAsistencia;
        this.dia = dia;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public String getIdAsistenciaTrabajador() {
        return idAsistenciaTrabajador;
    }

    public void setIdAsistenciaTrabajador(String idAsistenciaTrabajador) {
        this.idAsistenciaTrabajador = idAsistenciaTrabajador;
    }

    public String getNombreAsistencia() {
        return NombreAsistencia;
    }

    public void setNombreAsistencia(String NombreAsistencia) {
        this.NombreAsistencia = NombreAsistencia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AsistenciaTrabajador{" + "idAsistenciaTrabajador=" + idAsistenciaTrabajador + ", NombreAsistencia=" + NombreAsistencia + ", dia=" + dia + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", estado=" + estado + '}';
    }

}
