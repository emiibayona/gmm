package com.magicbussines.gmm.interfacesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicbussines.gmm.interfaces.IPersonaPropietario;
import com.magicbussines.gmm.model.PersonaPropietario;
import com.magicbussines.gmm.repos.RepositoryPersonaPropietario;

@Service
public class IPersonaPropietarioImp implements IPersonaPropietario {

	@Autowired
	private RepositoryPersonaPropietario _repo;
	
	@Override
	public Iterable<PersonaPropietario> List() {
		// TODO Auto-generated method stub
		return (Iterable<PersonaPropietario>)_repo.findAll();
	}

	@Override
	public Optional<PersonaPropietario> Entity(String id) {
		// TODO Auto-generated method stub
		return null;
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
