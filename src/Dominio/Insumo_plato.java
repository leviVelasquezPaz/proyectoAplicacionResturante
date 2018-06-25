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
public class Insumo_plato {
    private String Id_Insumo_plato;
    private String Id_insumo;
    private  String Id_plato;
    private String estado;

    public Insumo_plato(String Id_Insumo_plato, String Id_insumo, String Id_plato, String estado) {
        this.Id_Insumo_plato = Id_Insumo_plato;
        this.Id_insumo = Id_insumo;
        this.Id_plato = Id_plato;
        this.estado = estado;
    }

    public String getId_Insumo_plato() {
        return Id_Insumo_plato;
    }

    public void setId_Insumo_plato(String Id_Insumo_plato) {
        this.Id_Insumo_plato = Id_Insumo_plato;
    }

    public String getId_insumo() {
        return Id_insumo;
    }

    public void setId_insumo(String Id_insumo) {
        this.Id_insumo = Id_insumo;
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
        return "Insumo_plato{" + "Id_Insumo_plato=" + Id_Insumo_plato + ", Id_insumo=" + Id_insumo + ", Id_plato=" + Id_plato + ", estado=" + estado + '}';
    }
    
    
}
