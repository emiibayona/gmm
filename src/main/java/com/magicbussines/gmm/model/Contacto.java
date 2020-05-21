package com.magicbussines.gmm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contacto implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="nroApto")
	private Apartamento nroApto;

	@Id
	private String telefono;
	
	@Column
	private String nombre;
	@Column
	private String apellido;
	
	public Apartamento getNroApto() {
		return nroApto;
	}
	public void setNroApto(Apartamento nroApto) {
		this.nroApto = nroApto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Contacto(Apartamento nroApto, String telefono, String nombre, String apellido) {
		super();
		this.nroApto = nroApto;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
