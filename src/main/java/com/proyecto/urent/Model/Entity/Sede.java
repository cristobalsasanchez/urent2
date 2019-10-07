package com.proyecto.urent.Model.Entity;

import javax.persistence.*;

@Entity
@Table(name = "sede")
public class Sede {
    private Integer idSede;
    private String nombre;
    private String direccion;
    private Universidad idUniversidad;
    private Integer estado;

    @Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @ManyToOne
    @JoinColumn(name="idUniversidad")
    public Universidad getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Universidad idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    @Column(name="estado")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }



}
