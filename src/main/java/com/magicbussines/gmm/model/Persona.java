package com.magicbussines.gmm.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona { 
	
	@Id
	protected String documento;
	
	@Column
	protected String nombre;
	
	@Column
	protected String apellido1;
	
	@Column
	protected String apellido2;
	
	@Column
	protected String telefono;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Persona(String documento, String nombre, String apellido1, String apellido2, String telefono) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
	}

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
