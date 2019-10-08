package com.urent.springboot.web.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Inmueble database table.
 * 
 */
@Entity
@NamedQuery(name="Inmueble.findAll", query="SELECT i FROM Inmueble i")
public class Inmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int IDInmueble;

	private int agua;

	private int cocina;

	private String descripcion;

	private String direccion;

	private int disponibilidad;

	private int estacionamiento;

	private byte estado;

	private int gas;

	private int luz;

	private int nroBaños;

	private int nroHabitaciones;

	private int precioMensual;

	private int wifi;

	//bi-directional many-to-one association to Arriendo
	@OneToMany(mappedBy="inmueble")
	private List<Arriendo> arriendos;

	//bi-directional many-to-one association to Distancia
	@OneToMany(mappedBy="inmueble")
	private List<Distancia> distancias;

	//bi-directional many-to-one association to Propiedad
	@ManyToOne
	@JoinColumn(name="IDPropiedad")
	private Propiedad propiedad;

	public Inmueble() {
	}

	public int getIDInmueble() {
		return this.IDInmueble;
	}

	public void setIDInmueble(int IDInmueble) {
		this.IDInmueble = IDInmueble;
	}

	public int getAgua() {
		return this.agua;
	}

	public void setAgua(int agua) {
		this.agua = agua;
	}

	public int getCocina() {
		return this.cocina;
	}

	public void setCocina(int cocina) {
		this.cocina = cocina;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getEstacionamiento() {
		return this.estacionamiento;
	}

	public void setEstacionamiento(int estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public int getGas() {
		return this.gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

	public int getLuz() {
		return this.luz;
	}

	public void setLuz(int luz) {
		this.luz = luz;
	}

	public int getNroBaños() {
		return this.nroBaños;
	}

	public void setNroBaños(int nroBaños) {
		this.nroBaños = nroBaños;
	}

	public int getNroHabitaciones() {
		return this.nroHabitaciones;
	}

	public void setNroHabitaciones(int nroHabitaciones) {
		this.nroHabitaciones = nroHabitaciones;
	}

	public int getPrecioMensual() {
		return this.precioMensual;
	}

	public void setPrecioMensual(int precioMensual) {
		this.precioMensual = precioMensual;
	}

	public int getWifi() {
		return this.wifi;
	}

	public void setWifi(int wifi) {
		this.wifi = wifi;
	}

	public List<Arriendo> getArriendos() {
		return this.arriendos;
	}

	public void setArriendos(List<Arriendo> arriendos) {
		this.arriendos = arriendos;
	}

	public Arriendo addArriendo(Arriendo arriendo) {
		getArriendos().add(arriendo);
		arriendo.setInmueble(this);

		return arriendo;
	}

	public Arriendo removeArriendo(Arriendo arriendo) {
		getArriendos().remove(arriendo);
		arriendo.setInmueble(null);

		return arriendo;
	}

	public List<Distancia> getDistancias() {
		return this.distancias;
	}

	public void setDistancias(List<Distancia> distancias) {
		this.distancias = distancias;
	}

	public Distancia addDistancia(Distancia distancia) {
		getDistancias().add(distancia);
		distancia.setInmueble(this);

		return distancia;
	}

	public Distancia removeDistancia(Distancia distancia) {
		getDistancias().remove(distancia);
		distancia.setInmueble(null);

		return distancia;
	}

	public Propiedad getPropiedad() {
		return this.propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

}