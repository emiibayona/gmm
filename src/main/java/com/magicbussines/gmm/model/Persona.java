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


	//GET AND SET
}
