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
public class Reportes {

    private String Id_reportes;
    private int cantidad;
    private Date fecha_consumo;
    private String estado;

    public Reportes(String Id_reportes, int cantidad, Date fecha_consumo, String estado) {
        this.Id_reportes = Id_reportes;
        this.cantidad = cantidad;
        this.fecha_consumo = fecha_consumo;
        this.estado = estado;
    }

    public String getId_reportes() {
        return Id_reportes;
    }

    public void setId_reportes(String Id_reportes) {
        this.Id_reportes = Id_reportes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_consumo() {
        return fecha_consumo;
    }

    public void setFecha_consumo(Date fecha_consumo) {
        this.fecha_consumo = fecha_consumo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reportes{" + "Id_reportes=" + Id_reportes + ", cantidad=" + cantidad + ", fecha_consumo=" + fecha_consumo + ", estado=" + estado + '}';
    }
    
    

}
