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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public PersonaUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(PersonaUsuario usuario) {
		this.usuario = usuario;
	}

	public Nota(int id, String titulo, String texto, LocalDateTime timestamp, PersonaUsuario usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.timestamp = timestamp;
		this.usuario = usuario;
	}

	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//GET AND SET
	
}
