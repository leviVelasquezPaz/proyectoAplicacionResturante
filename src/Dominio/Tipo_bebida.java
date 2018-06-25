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
public class Tipo_bebida {

    private String Id_tipoBebida;
    private String Id_pedido;
    private String Id_pedidoBebida;
    private String descripcion;
    private int cantidad;
    private String estado;

    public Tipo_bebida(String Id_tipoBebida, String Id_pedido, String Id_pedidoBebida, String descripcion, int cantidad, String estado) {
        this.Id_tipoBebida = Id_tipoBebida;
        this.Id_pedido = Id_pedido;
        this.Id_pedidoBebida = Id_pedidoBebida;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getId_tipoBebida() {
        return Id_tipoBebida;
    }

    public void setId_tipoBebida(String Id_tipoBebida) {
        this.Id_tipoBebida = Id_tipoBebida;
    }

    public String getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(String Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public String getId_pedidoBebida() {
        return Id_pedidoBebida;
    }

    public void setId_pedidoBebida(String Id_pedidoBebida) {
        this.Id_pedidoBebida = Id_pedidoBebida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tipo_bebida{" + "Id_tipoBebida=" + Id_tipoBebida + ", Id_pedido=" + Id_pedido + ", Id_pedidoBebida=" + Id_pedidoBebida + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }

}