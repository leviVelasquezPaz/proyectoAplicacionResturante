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
public class Cocinero_plato {

    private String Id_cocinero_plato;
    private String Id_plato;
    private String estado;

    public Cocinero_plato(String Id_cocinero_plato, String Id_plato, String estado) {
        this.Id_cocinero_plato = Id_cocinero_plato;
        this.Id_plato = Id_plato;
        this.estado = estado;
    }

    public String getId_cocinero_plato() {
        return Id_cocinero_plato;
    }

    public void setId_cocinero_plato(String Id_cocinero_plato) {
        this.Id_cocinero_plato = Id_cocinero_plato;
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
        return "Cocinero_plato{" + "Id_cocinero_plato=" + Id_cocinero_plato + ", Id_plato=" + Id_plato + ", estado=" + estado + '}';
    }
    
    
    
}


            
