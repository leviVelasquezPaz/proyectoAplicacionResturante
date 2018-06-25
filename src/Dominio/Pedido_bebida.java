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
public class Pedido_bebida {
    private  String Id_pedido_bebida;
    private String Id_bebida;
    private String Id_pedido;
    private int cantidad;
    private String estado;

    public Pedido_bebida(String Id_pedido_bebida, String Id_bebida, String Id_pedido, int cantidad, String estado) {
        this.Id_pedido_bebida = Id_pedido_bebida;
        this.Id_bebida = Id_bebida;
        this.Id_pedido = Id_pedido;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getId_pedido_bebida() {
        return Id_pedido_bebida;
    }

    public void setId_pedido_bebida(String Id_pedido_bebida) {
        this.Id_pedido_bebida = Id_pedido_bebida;
    }

    public String getId_bebida() {
        return Id_bebida;
    }

    public void setId_bebida(String Id_bebida) {
        this.Id_bebida = Id_bebida;
    }

    public String getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(String Id_pedido) {
        this.Id_pedido = Id_pedido;
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
        return "Pedido_bebida{" + "Id_pedido_bebida=" + Id_pedido_bebida + ", Id_bebida=" + Id_bebida + ", Id_pedido=" + Id_pedido + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }
    
    
    
            }
