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
public class Pedido {

    private String Id_pedido;
    private String Id_cliente;
    private String Id_mesa;
    private String Id_moso;
    private Date fecha;
    private String estado;

    public Pedido(String Id_pedido, String Id_cliente, String Id_mesa, String Id_moso, Date fecha, String estado) {
        this.Id_pedido = Id_pedido;
        this.Id_cliente = Id_cliente;
        this.Id_mesa = Id_mesa;
        this.Id_moso = Id_moso;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getId_pedido() {
        return Id_pedido;
    }

    public void setId_pedido(String Id_pedido) {
        this.Id_pedido = Id_pedido;
    }

    public String getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(String Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public String getId_mesa() {
        return Id_mesa;
    }

    public void setId_mesa(String Id_mesa) {
        this.Id_mesa = Id_mesa;
    }

    public String getId_moso() {
        return Id_moso;
    }

    public void setId_moso(String Id_moso) {
        this.Id_moso = Id_moso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "Id_pedido=" + Id_pedido + ", Id_cliente=" + Id_cliente + ", Id_mesa=" + Id_mesa + ", Id_moso=" + Id_moso + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

}