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
public class PedidoPlato {
  private String id_Pedido_Plato;
  private String cantidad;
  private String Id_pedido;
  private String Id_plato;
  private String estado;

    public PedidoPlato(String id_Pedido_Plato, String cantidad, String Id_pedido, String Id_plato, String estado) {
        this.id_Pedido_Plato = id_Pedido_Plato;
        this.cantidad = cantidad;
        this.Id_pedido = Id_pedido;
        this.Id_plato = Id_plato;
        this.estado = estado;
    }

    public String getId_Pedido_Plato() {
        return id_Pedido_Plato;
    }

    public void setId_Pedido_Plato(String id_Pedido_Plato) {
        this.id_Pedido_Plato = id_Pedido_Plato;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(String Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public String getId_plato() {
        return Id_plato;
    }

    public void setId_plato(String Id_plato) {
        this.Id_plato = Id_plato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PedidoPlato{" + "id_Pedido_Plato=" + id_Pedido_Plato + ", cantidad=" + cantidad + ", Id_pedido=" + Id_pedido + ", Id_plato=" + Id_plato + ", estado=" + estado + '}';
    }
  
}
