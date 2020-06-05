package com.magicbussines.gmm.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.magicbussines.gmm.model.Nota;

public interface RepositoryNotas extends CrudRepository<Nota, Integer> {
	
	@Query(nativeQuery = true, value = "select * from nota where documento =?documento")
	public Iterable<Nota> searchNoteByDocumento(String documento);
}
