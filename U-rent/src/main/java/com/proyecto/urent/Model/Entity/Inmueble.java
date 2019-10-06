package com.proyecto.urent.Model.Entity;

import javax.persistence.*;

@Entity
@Table(name = "inmueble")
public class Inmueble {
    private Integer idInmueble;
    private Integer nroHabitaciones;
    private Integer nroBanos;
    private Integer wifi;
    private Integer luz;
    private Integer agua;
    private Integer gas;
    private Integer cocina;
    private Integer precioMensual;
    private String descripcion;
    private Integer estacionamiento;
    private Integer disponibilidad;
    private String direccion;
    private Propiedad idPropiedad;
    private Integer estado;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    @Column(name="nroHabitaciones")
    public Integer getNroHabitaciones() {
        return nroHabitaciones;
    }

    public void setNroHabitaciones(Integer nroHabitaciones) {
        this.nroHabitaciones = nroHabitaciones;
    }
    @Column(name="nroBanos")
    public Integer getNroBanos() {
        return nroBanos;
    }

    public void setNroBanos(Integer nroBanos) {
        this.nroBanos = nroBanos;
    }

    @Column(name="wifi")
    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    @Column(name="luz")
    public Integer getLuz() {
        return luz;
    }

    public void setLuz(Integer luz) {
        this.luz = luz;
    }

    @Column(name="agua")
    public Integer getAgua() {
        return agua;
    }

    public void setAgua(Integer agua) {
        this.agua = agua;
    }

    @Column(name="gas")
    public Integer getGas() {
        return gas;
    }

    public void setGas(Integer gas) {
        this.gas = gas;
    }

    @Column(name="cocina")
    public Integer getCocina() {
        return cocina;
    }

    public void setCocina(Integer cocina) {
        this.cocina = cocina;
    }

    @Column(name="precioMensual")
    public Integer getPrecioMensual() {
        return precioMensual;
    }

    public void setPrecioMensual(Integer precioMensual) {
        this.precioMensual = precioMensual;
    }

    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="estacionamiento")
    public Integer getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Integer estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    @Column(name="disponibilidad")
    public Integer getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Column(name="direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @ManyToOne
    @JoinColumn(name="idPropiedad")
    public Propiedad getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Propiedad idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    @Column(name="estado")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }


}
