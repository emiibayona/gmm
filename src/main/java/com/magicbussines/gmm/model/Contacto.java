package com.magicbussines.gmm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contacto implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="nroApto")
	private Apartamento nroAptoContacto;

	@Id
	private String telefono;
	
	@Column
	private String nombre;
	@Column
	private String apellido;
	
	
	
}
