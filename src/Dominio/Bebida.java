/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Usuario
 */
public class Bebida {

    private String Id_bebida;
    private String Id_tipoBebida;
    private String Nombre_bebida;
    private double PrecioVenta;
    private String estado;

    public Bebida(String Id_bebida, String Id_tipoBebida, String Nombre_bebida, double PrecioVenta, String estado) {
        this.Id_bebida = Id_bebida;
        this.Id_tipoBebida = Id_tipoBebida;
        this.Nombre_bebida = Nombre_bebida;
        this.PrecioVenta = PrecioVenta;
        this.estado = estado;
    }

    public String getId_bebida() {
        return Id_bebida;
    }

    public void setId_bebida(String Id_bebida) {
        this.Id_bebida = Id_bebida;
    }

    public String getId_tipoBebida() {
        return Id_tipoBebida;
    }

    public void setId_tipoBebida(String Id_tipoBebida) {
        this.Id_tipoBebida = Id_tipoBebida;
    }

    public String getNombre_bebida() {
        return Nombre_bebida;
    }

    public void setNombre_bebida(String Nombre_bebida) {
        this.Nombre_bebida = Nombre_bebida;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Bebida{" + "Id_bebida=" + Id_bebida + ", Id_tipoBebida=" + Id_tipoBebida + ", Nombre_bebida=" + Nombre_bebida + ", PrecioVenta=" + PrecioVenta + ", estado=" + estado + '}';
    }

}
