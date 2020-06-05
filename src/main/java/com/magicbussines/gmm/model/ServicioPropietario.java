package com.magicbussines.gmm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServicioPropietario extends Servicio{

	private String ciPropietario;

	public String getPropietario() {
		return ciPropietario;
	}

	public void setPropietario(String ciPropietario) {
		this.ciPropietario = ciPropietario;
	}
	
	
}
