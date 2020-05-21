package com.magicbussines.gmm.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Apartamento {

	@Id
	@NotNull
	private int nroApto;
	
	@Column
	private String notas;
	
	@Column
	private boolean libre;
	
	@ManyToOne
	@JoinColumn(name="documento")
	private PersonaPropietario propietario;
	
}
