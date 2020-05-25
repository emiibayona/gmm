package com.magicbussines.gmm.interfaces;

import java.util.Optional;

import com.magicbussines.gmm.model.PersonaInquilino;

public interface IPersonaInquilino {
	public Iterable<PersonaInquilino> List();
	public Optional<PersonaInquilino> Entity(String id);
	public PersonaInquilino Save(PersonaInquilino obj); //save funciona para la primera vez o para update
	public void Delete(String id);
}

