package com.proyecto.urent.Model.Entity;

import javax.persistence.*;


@Entity
@Table(name = "universidad")
public class Universidad {
    private Integer idUniversidad;
    private String nombre;
    private Integer estado;


    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Integer idUniversidad) {
        this.idUniversidad = idUniversidad;
    }


    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="estado")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
