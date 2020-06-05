package com.magicbussines.gmm.interfaces;

import java.util.Optional;
import com.magicbussines.gmm.model.PersonaPropietario;
import com.magicbussines.gmm.model.PersonaUsuario;

public interface IPersonaUsuario {
	public Iterable<PersonaUsuario> List();
	public Iterable<PersonaUsuario> ListarActivos();
	public Iterable<PersonaUsuario> ListarInactivos();
	public Optional<PersonaUsuario> Entity(String login, String password);
	public Optional<PersonaUsuario> EntityById(String documento);
	public PersonaUsuario Save(PersonaUsuario obj); //save funciona para la primera vez o para update
	public void Delete(String id);
	public void DesactivateUser(String id);
	public void ReactivateUser(String id);
	
}

