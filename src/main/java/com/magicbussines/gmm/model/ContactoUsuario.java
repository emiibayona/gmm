package com.magicbussines.gmm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContactoUsuario extends Contacto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name="documento")
	private PersonaUsuario usuario;

	public PersonaUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(PersonaUsuario usuario) {
		this.usuario = usuario;
	}
	
	
}
