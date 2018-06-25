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
public class Insumo_bebida {
    private String Id_Isumo_bebida;
    private String Id_bebida;
    private String Id_insumo;
    private String estado;

    public Insumo_bebida(String Id_Isumo_bebida, String Id_bebida, String Id_insumo, String estado) {
        this.Id_Isumo_bebida = Id_Isumo_bebida;
        this.Id_bebida = Id_bebida;
        this.Id_insumo = Id_insumo;
        this.estado = estado;
    }

    public String getId_Isumo_bebida() {
        return Id_Isumo_bebida;
    }

    public void setId_Isumo_bebida(String Id_Isumo_bebida) {
        this.Id_Isumo_bebida = Id_Isumo_bebida;
    }

    public String getId_bebida() {
        return Id_bebida;
    }

    public void setId_bebida(String Id_bebida) {
        this.Id_bebida = Id_bebida;
    }

    public String getId_insumo() {
        return Id_insumo;
    }

    public void setId_insumo(String Id_insumo) {
        this.Id_insumo = Id_insumo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Insumo_bebida{" + "Id_Isumo_bebida=" + Id_Isumo_bebida + ", Id_bebida=" + Id_bebida + ", Id_insumo=" + Id_insumo + ", estado=" + estado + '}';
    }
    
    
}
