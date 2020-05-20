package com.magicbussines.gmm.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Inhouse")
public class Inhouse { 
	//se debe generar trigger cuando se haga una accion sobre un Inhouse

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale="America/Montevideo")
	private LocalDateTime timestamp;
	
	//Notes about in-house
	private String comentario;
	
		// enumerado por tipo de usuario sobre el inhouse
	/*private enum TipoPersona{
			Inquilino,
			Propietario
		};
	private TipoPersona tipoPersona;
	
	// FK con apto
	@ManyToOne
	@JoinColumn(name="nroApto")
	private Apartamento apto;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	/*public Apartamento getApto() {
		return apto;
	}

	public void setApto(Apartamento apto) {
		this.apto = apto;
	}*/

	public Inhouse(int id, LocalDateTime timestamp, String comentario) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.comentario = comentario;
	}

	public Inhouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

