package com.magicbussines.gmm.repos;

import java.util.Optional;


import javax.persistence.IdClass;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.magicbussines.gmm.model.Persona;
import com.magicbussines.gmm.model.PersonaPropietario;
import com.magicbussines.gmm.model.PersonaUsuario;

//@RepositoryDefinition(domainClass = Persona.class, idClass = Persona.class)
public interface RepositoryPersonaUsuario extends CrudRepository<PersonaUsuario, String>{

	@Query(nativeQuery = true, value ="select * from persona_usuario where login =?1 and password =?2")
	public Optional<PersonaUsuario> findByLoginPassword(String login, String password);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value ="update persona_usuario set deleted = created_on where documento =?1")
	public void reactUser(String documento);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value ="update persona_usuario set deleted = now() where documento =?1")
	public void desactivarUser(String documento);
	
	@Query(nativeQuery = true, value ="select * from persona_usuario where deleted = created_on")
	public Iterable<PersonaUsuario> findAllActive();
	
	@Query(nativeQuery = true, value ="select * from persona_usuario where deleted <> created_on")
	public Iterable<PersonaUsuario> findAllInactive();
	
}
