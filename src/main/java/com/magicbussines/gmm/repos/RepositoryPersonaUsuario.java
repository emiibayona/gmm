package com.magicbussines.gmm.repos;

import java.util.Optional;


import javax.persistence.IdClass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.magicbussines.gmm.model.Persona;
import com.magicbussines.gmm.model.PersonaPropietario;
import com.magicbussines.gmm.model.PersonaUsuario;

//@RepositoryDefinition(domainClass = Persona.class, idClass = Persona.class)
public abstract interface RepositoryPersonaUsuario extends CrudRepository<PersonaUsuario, String>{

	@Query(nativeQuery = true, value ="select * from PersonaUsuario where login =?1 and password =?2")
	public Optional<PersonaUsuario> findByLoginPassword(String login, String password);
}
