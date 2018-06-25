/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author levi
 */
public class Venta {
   private String idVenta;
   private String Id_pedido;
   private String estado;

    public Venta(String idVenta, String Id_pedido, String estado) {
        this.idVenta = idVenta;
        this.Id_pedido = Id_pedido;
        this.estado = estado;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(String Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", Id_pedido=" + Id_pedido + ", estado=" + estado + '}';
    }

}