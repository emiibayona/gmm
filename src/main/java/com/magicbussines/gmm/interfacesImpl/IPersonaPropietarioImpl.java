package com.magicbussines.gmm.interfacesImpl;

import java.util.Optional;

import javax.persistence.IdClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.magicbussines.gmm.interfaces.IPersonaPropietario;
import com.magicbussines.gmm.model.Persona;
import com.magicbussines.gmm.model.PersonaPropietario;
import com.magicbussines.gmm.repos.RepositoryPersona;

@Service
public class IPersonaPropietarioImpl implements IPersonaPropietario {

	@Autowired
	private RepositoryPersona _repo;
	
	@Override
	public Iterable<PersonaPropietario> List() {
		// TODO Auto-generated method stub
		return _repo.findAll();
	}

	@Override
	public Optional<PersonaPropietario> Entity(String id) {
		// TODO Auto-generated method stub
		return (Optional<PersonaPropietario>) _repo.findById(id);
	}

	@Override
	public PersonaPropietario Save(PersonaPropietario obj) {
		// TODO Auto-generated method stub
		return _repo.save(obj);
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		_repo.deleteById(id);
		
	}


}
