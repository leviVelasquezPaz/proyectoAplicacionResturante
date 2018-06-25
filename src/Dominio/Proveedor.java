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
public class Proveedor {

    private String Id_proveedor;
    private String Nombre;
    private String A_paterno;
    private String A_materno;
    private int DNI;
    private int telefono;
    private String direccion;
    private String E_mail;
    private String estado;

    public Proveedor(String Id_proveedor, String Nombre, String A_paterno, String A_materno, int DNI, int telefono, String direccion, String E_mail, String estado) {
        this.Id_proveedor = Id_proveedor;
        this.Nombre = Nombre;
        this.A_paterno = A_paterno;
        this.A_materno = A_materno;
        this.DNI = DNI;
        this.telefono = telefono;
        this.direccion = direccion;
        this.E_mail = E_mail;
        this.estado = estado;
    }

    public String getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(String Id_proveedor) {
        this.Id_proveedor = Id_proveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "Id_proveedor=" + Id_proveedor + ", Nombre=" + Nombre + ", A_paterno=" + A_paterno + ", A_materno=" + A_materno + ", DNI=" + DNI + ", telefono=" + telefono + ", direccion=" + direccion + ", E_mail=" + E_mail + ", estado=" + estado + '}';
    }
    
    
    
}
