package com.urent.springboot.web.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Arrendatario database table.
 * 
 */
@Entity
@NamedQuery(name="Arrendatario.findAll", query="SELECT a FROM Arrendatario a")
public class Arrendatario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String RUTArrendatario;

	private double calificacion;

	private String correo;

	private byte estado;

	private String nombre;

	private String telefono;

	private String universidadDefecto;

	//bi-directional many-to-one association to Arriendo
	@OneToMany(mappedBy="arrendatario")
	private List<Arriendo> arriendos;

	public Arrendatario() {
	}

	public String getRUTArrendatario() {
		return this.RUTArrendatario;
	}

	public void setRUTArrendatario(String RUTArrendatario) {
		this.RUTArrendatario = RUTArrendatario;
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

	public String getUniversidadDefecto() {
		return this.universidadDefecto;
	}

	public void setUniversidadDefecto(String universidadDefecto) {
		this.universidadDefecto = universidadDefecto;
	}

	public List<Arriendo> getArriendos() {
		return this.arriendos;
	}

	public void setArriendos(List<Arriendo> arriendos) {
		this.arriendos = arriendos;
	}

	public Arriendo addArriendo(Arriendo arriendo) {
		getArriendos().add(arriendo);
		arriendo.setArrendatario(this);

		return arriendo;
	}

	public Arriendo removeArriendo(Arriendo arriendo) {
		getArriendos().remove(arriendo);
		arriendo.setArrendatario(null);

		return arriendo;
	}

}