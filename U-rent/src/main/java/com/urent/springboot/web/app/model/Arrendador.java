package com.urent.springboot.web.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Arrendador database table.
 * 
 */
@Entity
@NamedQuery(name="Arrendador.findAll", query="SELECT a FROM Arrendador a")
public class Arrendador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String RUTArrendador;

	private double calificacion;

	private String correo;

	private byte estado;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Arriendo
	@OneToMany(mappedBy="arrendador")
	private List<Arriendo> arriendos;

	//bi-directional many-to-one association to Propiedad
	@OneToMany(mappedBy="arrendador")
	private List<Propiedad> propiedads;

	public Arrendador() {
	}

	public String getRUTArrendador() {
		return this.RUTArrendador;
	}

	public void setRUTArrendador(String RUTArrendador) {
		this.RUTArrendador = RUTArrendador;
	}

	public double getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Arriendo> getArriendos() {
		return this.arriendos;
	}

	public void setArriendos(List<Arriendo> arriendos) {
		this.arriendos = arriendos;
	}

	public Arriendo addArriendo(Arriendo arriendo) {
		getArriendos().add(arriendo);
		arriendo.setArrendador(this);

		return arriendo;
	}

	public Arriendo removeArriendo(Arriendo arriendo) {
		getArriendos().remove(arriendo);
		arriendo.setArrendador(null);

		return arriendo;
	}

	public List<Propiedad> getPropiedads() {
		return this.propiedads;
	}

	public void setPropiedads(List<Propiedad> propiedads) {
		this.propiedads = propiedads;
	}

	public Propiedad addPropiedad(Propiedad propiedad) {
		getPropiedads().add(propiedad);
		propiedad.setArrendador(this);

		return propiedad;
	}

	public Propiedad removePropiedad(Propiedad propiedad) {
		getPropiedads().remove(propiedad);
		propiedad.setArrendador(null);

		return propiedad;
	}

}