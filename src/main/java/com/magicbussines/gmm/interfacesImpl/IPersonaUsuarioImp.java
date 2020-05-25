package com.magicbussines.gmm.interfacesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.magicbussines.gmm.interfaces.IPersonaUsuario;
import com.magicbussines.gmm.model.PersonaUsuario;
import com.magicbussines.gmm.repos.RepositoryPersonaUsuario;

public class IPersonaUsuarioImp implements IPersonaUsuario {

	@Autowired
	private RepositoryPersonaUsuario _repo;
	
	@Override
	public Iterable<PersonaUsuario> List() {
		// TODO Auto-generated method stub
		return (Iterable<PersonaUsuario>)_repo.findAll();
	}

	@Override
	public Optional<PersonaUsuario> Entity(String login, String password) {
		// TODO Auto-generated method stub
		return _repo.findByLoginPassword(login, password);
	}

	@Override
	public Optional<PersonaUsuario> EntityById(String documento) {
		// TODO Auto-generated method stub
		return _repo.findById(documento);
	}

	@Override
	public PersonaUsuario Save(PersonaUsuario obj) {
		// TODO Auto-generated method stub
		return _repo.save(obj);
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		_repo.deleteById(id);
	}

}
