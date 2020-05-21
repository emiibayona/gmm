package com.magicbussines.gmm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Persona { 
	
	@Id
	@Column
	protected String documento;
	
	@Column
	protected String nombre;
	
	@Column
	protected String apellido1;
	
	@Column
	protected String apellido2;

	@Column
	protected Contacto contacto;

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

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Persona(String documento, String nombre, String apellido1, String apellido2, Contacto contacto) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.contacto = contacto;
	}

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	//GET AND SET
	
	
}
