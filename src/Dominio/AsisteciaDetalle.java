/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

public class AsisteciaDetalle {

    private String idAsistencia;
    private String idAsistenciaTrabajador;
    private String Id_trabajador;
    private String hora_llegada;
    private String fecha;
    private String estado;

    public AsisteciaDetalle(String idAsistencia, String idAsistenciaTrabajador, String Id_trabajador, String hora_llegada, String fecha, String estado) {
        this.idAsistencia = idAsistencia;
        this.idAsistenciaTrabajador = idAsistenciaTrabajador;
        this.Id_trabajador = Id_trabajador;
        this.hora_llegada = hora_llegada;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(String idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public String getIdAsistenciaTrabajador() {
        return idAsistenciaTrabajador;
    }

    public void setIdAsistenciaTrabajador(String idAsistenciaTrabajador) {
        this.idAsistenciaTrabajador = idAsistenciaTrabajador;
    }

    public String getId_trabajador() {
        return Id_trabajador;
    }

    public void setId_trabajador(String Id_trabajador) {
        this.Id_trabajador = Id_trabajador;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AsisteciaDetalle{" + "idAsistencia=" + idAsistencia + ", idAsistenciaTrabajador=" + idAsistenciaTrabajador + ", Id_trabajador=" + Id_trabajador + ", hora_llegada=" + hora_llegada + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

}
