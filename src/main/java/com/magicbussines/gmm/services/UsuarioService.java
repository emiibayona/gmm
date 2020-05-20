package com.magicbussines.gmm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicbussines.gmm.interfaceServices.IUsuarioService;
import com.magicbussines.gmm.interfaces.IUsuario;
import com.magicbussines.gmm.models.Usuario;
@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuario data;
	
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method s tub
		return (List<Usuario>) data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(long ci) {
		
		return data.findById(ci);
		// TODO Auto-generated method stub
	}

	@Override
	public int save(Usuario u) {
		// TODO Auto-generated method stub
		int res=0;
		Usuario user =data.save(u);
		if (!user.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(long ci) {
		// TODO Auto-generated method stub
		data.deleteById(ci);		
	}

}
