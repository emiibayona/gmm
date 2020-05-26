package com.magicbussines.gmm.repos;

import java.util.Optional;


import javax.persistence.IdClass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.magicbussines.gmm.model.Persona;
import com.magicbussines.gmm.model.PersonaInquilino;
import com.magicbussines.gmm.model.PersonaPropietario;

//@RepositoryDefinition(domainClass = Persona.class, idClass = Persona.class)
public interface RepositoryPersonaInquilino extends CrudRepository<PersonaInquilino, String>{


}
