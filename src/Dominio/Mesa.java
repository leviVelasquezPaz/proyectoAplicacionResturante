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
public class Mesa {

    private String Id_mesa;
    private String Id_tipo_de_mesa;
    private int Cantidad_En_mesa;
    private String estado;

    public Mesa(String Id_mesa, String Id_tipo_de_mesa, int Cantidad_En_mesa, String estado) {
        this.Id_mesa = Id_mesa;
        this.Id_tipo_de_mesa = Id_tipo_de_mesa;
        this.Cantidad_En_mesa = Cantidad_En_mesa;
        this.estado = estado;
    }

    public String getId_mesa() {
        return Id_mesa;
    }

    public void setId_mesa(String Id_mesa) {
        this.Id_mesa = Id_mesa;
    }

    public String getId_tipo_de_mesa() {
        return Id_tipo_de_mesa;
    }

    public void setId_tipo_de_mesa(String Id_tipo_de_mesa) {
        this.Id_tipo_de_mesa = Id_tipo_de_mesa;
    }

    public int getCantidad_En_mesa() {
        return Cantidad_En_mesa;
    }

    public void setCantidad_En_mesa(int Cantidad_En_mesa) {
        this.Cantidad_En_mesa = Cantidad_En_mesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesa{" + "Id_mesa=" + Id_mesa + ", Id_tipo_de_mesa=" + Id_tipo_de_mesa + ", Cantidad_En_mesa=" + Cantidad_En_mesa + ", estado=" + estado + '}';
    }

}
