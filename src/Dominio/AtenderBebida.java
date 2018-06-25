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
public class AtenderBebida {
   private String idatender_Bebida;
   private String Id_bebida;
   private String Id_trabajador;
   private String estado;

    public AtenderBebida(String idatender_Bebida, String Id_bebida, String Id_trabajador, String estado) {
        this.idatender_Bebida = idatender_Bebida;
        this.Id_bebida = Id_bebida;
        this.Id_trabajador = Id_trabajador;
        this.estado = estado;
    }

    public String getIdatender_Bebida() {
        return idatender_Bebida;
    }

    public void setIdatender_Bebida(String idatender_Bebida) {
        this.idatender_Bebida = idatender_Bebida;
    }

    public String getId_bebida() {
        return Id_bebida;
    }

    public void setId_bebida(String Id_bebida) {
        this.Id_bebida = Id_bebida;
    }

    public String getId_trabajador() {
        return Id_trabajador;
    }

    public void setId_trabajador(String Id_trabajador) {
        this.Id_trabajador = Id_trabajador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AtenderBebida{" + "idatender_Bebida=" + idatender_Bebida + ", Id_bebida=" + Id_bebida + ", Id_trabajador=" + Id_trabajador + ", estado=" + estado + '}';
    }

   
   
}
