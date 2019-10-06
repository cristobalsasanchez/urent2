package com.proyecto.urent.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "propiedades")
public class Propiedad {
    private Integer idPropiedad;
    @JsonFormat(pattern="yyyy-MMM-dd")
    private Date fechaInicio;
    @JsonFormat(pattern="yyyy-MMM-dd")
    private Date fechaTermino;
    private Arrendador idArrendador;
    private Integer estado;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    @Column(name="fechaInicio")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name="fechaTermino")
    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    @ManyToOne
    @JoinColumn(name="idArrendador")
    public Arrendador getIdArrendador() {
        return idArrendador;
    }

    public void setIdArrendador(Arrendador idArrendador) {
        this.idArrendador = idArrendador;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
