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
public class Plato {

    private String Id_plato;
    private String Id_tipoPlato;
    private String nombre;
    private double PrecioVenta;
    private String imagen;
    private String Estado;

    public Plato(String Id_plato, String Id_tipoPlato, String nombre, double PrecioVenta, String imagen, String Estado) {
        this.Id_plato = Id_plato;
        this.Id_tipoPlato = Id_tipoPlato;
        this.nombre = nombre;
        this.PrecioVenta = PrecioVenta;
        this.imagen = imagen;
        this.Estado = Estado;
    }

    public String getId_plato() {
        return Id_plato;
    }

    public void setId_plato(String Id_plato) {
        this.Id_plato = Id_plato;
    }

    public String getId_tipoPlato() {
        return Id_tipoPlato;
    }

    public void setId_tipoPlato(String Id_tipoPlato) {
        this.Id_tipoPlato = Id_tipoPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Plato{" + "Id_plato=" + Id_plato + ", Id_tipoPlato=" + Id_tipoPlato + ", nombre=" + nombre + ", PrecioVenta=" + PrecioVenta + ", imagen=" + imagen + ", Estado=" + Estado + '}';
    }

}
