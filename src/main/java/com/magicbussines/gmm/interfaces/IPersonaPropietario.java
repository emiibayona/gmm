package com.magicbussines.gmm.interfaces;

import java.util.Optional;

import javax.persistence.IdClass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.objenesis.instantiator.annotations.Instantiator;

import com.magicbussines.gmm.model.Persona;
import com.magicbussines.gmm.model.PersonaPropietario;

import java.util.List;

public interface IPersonaPropietario{

	public Iterable<PersonaPropietario> List();
	public Optional<PersonaPropietario> Entity(String id);
	public PersonaPropietario Save(PersonaPropietario Obj); //save funciona para la primera vez o para update
	public void Delete(String id);
	
}
