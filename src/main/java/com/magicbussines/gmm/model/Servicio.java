package com.magicbussines.gmm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column
	protected String nombre;
	
	@Column
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale="America/Montevideo")
	protected LocalDateTime solicitado;
	
	@Column
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale="America/Montevideo")
	protected LocalDateTime hecho;
	
	@Column
	protected float costo;
	
	@Column
	protected boolean interno;
	
	@Column
	protected String notas;
	
	//SET and GET
	
}
