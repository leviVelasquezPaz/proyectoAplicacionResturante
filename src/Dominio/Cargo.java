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
public class Cargo {

    private String Id_cargo;
    private String Nombre_de_cargo;
    private double sueldo;
    private String estado;

    public Cargo(String Id_cargo, String Nombre_de_cargo, double sueldo, String estado) {
        this.Id_cargo = Id_cargo;
        this.Nombre_de_cargo = Nombre_de_cargo;
        this.sueldo = sueldo;
        this.estado = estado;
    }

    public String getId_cargo() {
        return Id_cargo;
    }

    public void setId_cargo(String Id_cargo) {
        this.Id_cargo = Id_cargo;
    }

    public String getNombre_de_cargo() {
        return Nombre_de_cargo;
    }

    public void setNombre_de_cargo(String Nombre_de_cargo) {
        this.Nombre_de_cargo = Nombre_de_cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cargo{" + "Id_cargo=" + Id_cargo + ", Nombre_de_cargo=" + Nombre_de_cargo + ", sueldo=" + sueldo + ", estado=" + estado + '}';
    }

}

