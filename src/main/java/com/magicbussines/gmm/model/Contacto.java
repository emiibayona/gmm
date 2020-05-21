package com.magicbussines.gmm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

// Esta entidad almacena contactos referidos a una persona, multivalued respecto de telefono

@MappedSuperclass
public abstract class Contacto implements Serializable{

	@Id
	@Column
	protected String telefono;
	@Column
	protected String email;
	@Column
	protected String nombre;
	@Column
	protected String apellido;
	
	// GET AND SET
	
	
}
