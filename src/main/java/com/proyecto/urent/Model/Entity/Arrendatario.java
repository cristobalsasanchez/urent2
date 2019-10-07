package com.proyecto.urent.Model.Entity;

import javax.persistence.*;

@Entity
@Table(name = "arrendatario")
public class Arrendatario {
    private Integer idArrendatario;
    private String rutArrendatario;
    private String nombre;
    private String telefono;
    private String correo;
    private Double calificacion;
    private Integer estado;

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdArrendatario() {
        return idArrendatario;
    }

    public void setIdArrendatario(Integer idArrendatario) {
        this.idArrendatario = idArrendatario;
    }


    @Column(name="rutArrendatario")
    public String getRutArrendatario() {
        return rutArrendatario;
    }

    public void setRutArrendatario(String rutArrendatario) {
        this.rutArrendatario = rutArrendatario;
    }

    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name="correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Column(name="calificacion")
    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    @Column(name="estado")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
