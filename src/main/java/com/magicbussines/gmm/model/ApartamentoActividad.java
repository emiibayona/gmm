package com.magicbussines.gmm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ApartamentoActividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="documento")
	private PersonaUsuario usuario;
	
	@Column
	private String acompaniante;
	
	@Column
	private String nombreEntra;
	
	@Column
	private String documentoEntra;
	
	@Column
	private String motivo;
	
	// firma digital a posterior :3
	
	//get and set
}
