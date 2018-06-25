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
public class Tipo_mesa {
    private String Id_tipo_de_mesa;
    private String descripcion;
    private String estado;

    public Tipo_mesa(String Id_tipo_de_mesa, String descripcion, String estado) {
        this.Id_tipo_de_mesa = Id_tipo_de_mesa;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getId_tipo_de_mesa() {
        return Id_tipo_de_mesa;
    }

    public void setId_tipo_de_mesa(String Id_tipo_de_mesa) {
        this.Id_tipo_de_mesa = Id_tipo_de_mesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tipo_mesa{" + "Id_tipo_de_mesa=" + Id_tipo_de_mesa + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }
    
    
}
