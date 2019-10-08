package com.urent.springboot.web.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Arriendo database table.
 * 
 */
@Entity
@NamedQuery(name="Arriendo.findAll", query="SELECT a FROM Arriendo a")
public class Arriendo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int IDArriendo;

	private byte estado;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	@Temporal(TemporalType.DATE)
	private Date fechatermino;

	//bi-directional many-to-one association to Arrendador
	@ManyToOne
	@JoinColumn(name="RUTArrendador")
	private Arrendador arrendador;

	//bi-directional many-to-one association to Arrendatario
	@ManyToOne
	@JoinColumn(name="RUTArrendatario")
	private Arrendatario arrendatario;

	//bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name="IDInmueble")
	private Inmueble inmueble;

	public Arriendo() {
	}

	public int getIDArriendo() {
		return this.IDArriendo;
	}

	public void setIDArriendo(int IDArriendo) {
		this.IDArriendo = IDArriendo;
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

	public Arrendador getArrendador() {
		return this.arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public Arrendatario getArrendatario() {
		return this.arrendatario;
	}

	public void setArrendatario(Arrendatario arrendatario) {
		this.arrendatario = arrendatario;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

}