package com.magicbussines.gmm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//Borrado logico simulando fisico
//@Where(clause = "deleted = false") 
public class PersonaUsuario extends Persona{
	
	// i need know the difference between admin or normal user
	@Column
	private String tipoUsuario;

	@Column
	@NotNull
	private String login;
	
	@Column
	@NotNull
	private String password;
	
	@Column(name = "deleted")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale="America/Montevideo")
	private LocalDateTime deleted;

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime isDeleted() {
		return deleted;
	}

	public void setDeleted(LocalDateTime deleted) {
		this.deleted = deleted;
	}
	
	
	public PersonaUsuario() {
		// TODO Auto-generated constructor stub
		this.createdOn = LocalDateTime.now();
		this.deleted = this.createdOn;
		
	}
	
}