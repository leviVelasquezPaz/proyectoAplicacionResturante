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
public class Tipo_plato {

    private String Id_Tipo_plato;
    private String Nombre;
    private String Estado;

    public Tipo_plato(String Id_Tipo_plato, String Nombre, String Estado) {
        this.Id_Tipo_plato = Id_Tipo_plato;
        this.Nombre = Nombre;
        this.Estado = Estado;
    }

    public String getId_Tipo_plato() {
        return Id_Tipo_plato;
    }

    public void setId_Tipo_plato(String Id_Tipo_plato) {
        this.Id_Tipo_plato = Id_Tipo_plato;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Tipo_plato{" + "Id_Tipo_plato=" + Id_Tipo_plato + ", Nombre=" + Nombre + ", Estado=" + Estado + '}';
    }

    
}

