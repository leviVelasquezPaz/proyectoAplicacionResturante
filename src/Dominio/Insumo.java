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
public class Insumo {

    private String Id_insumo;
    private String Id_proveedor;
    private int cantidad;
    private String estado;

    public Insumo(String Id_insumo, String Id_proveedor, int cantidad, String estado) {
        this.Id_insumo = Id_insumo;
        this.Id_proveedor = Id_proveedor;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getId_insumo() {
        return Id_insumo;
    }

    public void setId_insumo(String Id_insumo) {
        this.Id_insumo = Id_insumo;
    }

    public String getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(String Id_proveedor) {
        this.Id_proveedor = Id_proveedor;
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
        return "Insumo{" + "Id_insumo=" + Id_insumo + ", Id_proveedor=" + Id_proveedor + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }

}
