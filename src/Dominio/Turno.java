/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Turno {

    private String Id_turno;
    private String descripcion;
    private String Hora_Inicio;
    private String Hora_salida;
    private String estado;

    public Turno(String Id_turno, String descripcion, String Hora_Inicio, String Hora_salida, String estado) {
        this.Id_turno = Id_turno;
        this.descripcion = descripcion;
        this.Hora_Inicio = Hora_Inicio;
        this.Hora_salida = Hora_salida;
        this.estado = estado;
    }

    public String getId_turno() {
        return Id_turno;
    }

    public void setId_turno(String Id_turno) {
        this.Id_turno = Id_turno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(String Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public String getHora_salida() {
        return Hora_salida;
    }

    public void setHora_salida(String Hora_salida) {
        this.Hora_salida = Hora_salida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Turno{" + "Id_turno=" + Id_turno + ", descripcion=" + descripcion + ", Hora_Inicio=" + Hora_Inicio + ", Hora_salida=" + Hora_salida + ", estado=" + estado + '}';
    }

}
