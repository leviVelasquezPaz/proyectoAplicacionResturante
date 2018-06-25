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
public class Trabajador {

    private String Id_trabajador;
    private String Id_cargo;
    private String Id_turno;
    private String nombre;
    private String A_paterno;
    private String A_materno;
    private int DNI;
    private String Genero;
    private int Telefono;
    private String Direccion;
    private String E_mail;
    private String Estado;

    public Trabajador(String Id_trabajador, String Id_cargo, String Id_turno, String nombre, String A_paterno, String A_materno, int DNI, String Genero, int Telefono, String Direccion, String E_mail, String Estado) {
        this.Id_trabajador = Id_trabajador;
        this.Id_cargo = Id_cargo;
        this.Id_turno = Id_turno;
        this.nombre = nombre;
        this.A_paterno = A_paterno;
        this.A_materno = A_materno;
        this.DNI = DNI;
        this.Genero = Genero;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.E_mail = E_mail;
        this.Estado = Estado;
    }

    public String getId_trabajador() {
        return Id_trabajador;
    }

    public void setId_trabajador(String Id_trabajador) {
        this.Id_trabajador = Id_trabajador;
    }

    public String getId_cargo() {
        return Id_cargo;
    }

    public void setId_cargo(String Id_cargo) {
        this.Id_cargo = Id_cargo;
    }

    public String getId_turno() {
        return Id_turno;
    }

    public void setId_turno(String Id_turno) {
        this.Id_turno = Id_turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getA_paterno() {
        return A_paterno;
    }

    public void setA_paterno(String A_paterno) {
        this.A_paterno = A_paterno;
    }

    public String getA_materno() {
        return A_materno;
    }

    public void setA_materno(String A_materno) {
        this.A_materno = A_materno;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "Id_trabajador=" + Id_trabajador + ", Id_cargo=" + Id_cargo + ", Id_turno=" + Id_turno + ", nombre=" + nombre + ", A_paterno=" + A_paterno + ", A_materno=" + A_materno + ", DNI=" + DNI + ", Genero=" + Genero + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", E_mail=" + E_mail + ", Estado=" + Estado + '}';
    }

    
    
}
