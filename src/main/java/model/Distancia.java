package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Distancia database table.
 * 
 */
@Entity
@NamedQuery(name="Distancia.findAll", query="SELECT d FROM Distancia d")
public class Distancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDistancia;

	private byte estado;

	private double kilometros;

	//bi-directional many-to-one association to Sede
	@ManyToOne
	@JoinColumn(name="IDSede")
	private Sede sede;

	//bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name="IDInmueble")
	private Inmueble inmueble;

	public Distancia() {
	}

	public int getIdDistancia() {
		return this.idDistancia;
	}

	public void setIdDistancia(int idDistancia) {
		this.idDistancia = idDistancia;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public double getKilometros() {
		return this.kilometros;
	}

	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

}