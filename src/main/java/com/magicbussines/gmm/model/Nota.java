package com.magicbussines.gmm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String titulo;
	
	@Column
	private String texto;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale="America/Montevideo")
	private LocalDateTime timestamp;
	
	@ManyToOne
	@JoinColumn(name="documento")
	private PersonaUsuario usuario;
	
	//GET AND SET
	
}
