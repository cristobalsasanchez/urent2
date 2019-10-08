package com.urent.springboot.web.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Propiedad database table.
 * 
 */
@Entity
@NamedQuery(name="Propiedad.findAll", query="SELECT p FROM Propiedad p")
public class Propiedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int IDPropiedad;

	private byte estado;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	@Temporal(TemporalType.DATE)
	private Date fechatermino;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="propiedad")
	private List<Inmueble> inmuebles;

	//bi-directional many-to-one association to Arrendador
	@ManyToOne
	@JoinColumn(name="RUTArrendador")
	private Arrendador arrendador;

	public Propiedad() {
	}

	public int getIDPropiedad() {
		return this.IDPropiedad;
	}

	public void setIDPropiedad(int IDPropiedad) {
		this.IDPropiedad = IDPropiedad;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechatermino() {
		return this.fechatermino;
	}

	public void setFechatermino(Date fechatermino) {
		this.fechatermino = fechatermino;
	}

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}

	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Inmueble addInmueble(Inmueble inmueble) {
		getInmuebles().add(inmueble);
		inmueble.setPropiedad(this);

		return inmueble;
	}

	public Inmueble removeInmueble(Inmueble inmueble) {
		getInmuebles().remove(inmueble);
		inmueble.setPropiedad(null);

		return inmueble;
	}

	public Arrendador getArrendador() {
		return this.arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

}