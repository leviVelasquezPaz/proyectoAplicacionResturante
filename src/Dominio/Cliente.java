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
public class Cliente {

    private String idCliente;
    private String nombres;
    private String A_pateno;
    private String A_materno;
    private String sexo;
    private String direcion;
    private String correo;
    private int dni;
    private String telefono;
    private String estado;

    public Cliente(String idCliente, String nombres, String A_pateno, String A_materno, String sexo, String direcion, String correo, int dni, String telefono, String estado) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.A_pateno = A_pateno;
        this.A_materno = A_materno;
        this.sexo = sexo;
        this.direcion = direcion;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getA_pateno() {
        return A_pateno;
    }

    public void setA_pateno(String A_pateno) {
        this.A_pateno = A_pateno;
    }

    public String getA_materno() {
        return A_materno;
    }

    public void setA_materno(String A_materno) {
        this.A_materno = A_materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombres=" + nombres + ", A_pateno=" + A_pateno + ", A_materno=" + A_materno + ", sexo=" + sexo + ", direcion=" + direcion + ", correo=" + correo + ", dni=" + dni + ", telefono=" + telefono + ", estado=" + estado + '}';
    }

}
