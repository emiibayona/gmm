package com.magicbussines.gmm.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magicbussines.gmm.models.Usuario;
@Repository
public interface IUsuario extends CrudRepository<Usuario, Long> {

}
