package com.proyecto.urent.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "arriendo")
public class Arriendo {
    private Integer idArriendo;
    @JsonFormat(pattern="yyyy-MMM-dd")
    private Date fechaInicio;
    @JsonFormat(pattern="yyyy-MMM-dd")
    private Date fechaTermino;
    private Arrendador idArrendador;
    private Arrendatario idArrendatario;
    private Inmueble idInmueble;
    private Integer estado;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(Integer idArriendo) {
        this.idArriendo = idArriendo;
    }

    @Column(name = "fechaInicio")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "fechaTermino")
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

    @ManyToOne
    @JoinColumn(name="idArrendatario")
    public Arrendatario getIdArrendatario() {
        return idArrendatario;
    }

    public void setIdArrendatario(Arrendatario idArrendatario) {
        this.idArrendatario = idArrendatario;
    }

    @ManyToOne
    @JoinColumn(name="idInmueble")
    public Inmueble getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Inmueble idInmueble) {
        this.idInmueble = idInmueble;
    }

    @Column(name = "estado")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
