package com.proyecto.urent.Model.Entity;

import javax.persistence.*;


@Entity
@Table(name = "arrendador")
public class Arrendador {
    private Integer idArrendador;
    private String rutArrendador;
    private String nombre;
    private String telefono;
    private String correo;
    private Double calificacion;
    private Integer estado;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdArrendador() {
        return idArrendador;
    }

    public void setIdArrendador(Integer idArrendador) {
        this.idArrendador = idArrendador;
    }


    @Column(name="rutArrendador")
    public String getRutArrendador() {
        return rutArrendador;
    }

    public void setRutArrendador(String rutArrendador) {
        this.rutArrendador = rutArrendador;
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
