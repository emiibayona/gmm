package com.magicbussines.gmm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContactoPropietario extends Contacto {
	
	@Id
	@ManyToOne
	@JoinColumn(name="documento")
	private PersonaPropietario propietario;

	public PersonaPropietario getPropietario() {
		return propietario;
	}

	public void setPropietario(PersonaPropietario propietario) {
		this.propietario = propietario;
	}
	
	
}
