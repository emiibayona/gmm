package com.magicbussines.gmm.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magicbussines.gmm.interfaces.IPersonaPropietario;
import com.magicbussines.gmm.model.PersonaPropietario;

@RestController
@RequestMapping("/persona")
public class ControllerPersona {

	@Autowired
	private IPersonaPropietario _persona;
	
	@GetMapping("/")
	public ResponseEntity<Object> persona() {
		List<PersonaPropietario> personas = (List<PersonaPropietario>) _persona.List();
		if(personas.isEmpty()) {
			return new ResponseEntity<Object>("FALLO", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(personas,HttpStatus.OK);
	}
	

		//VeMec vemecSaved = vemecService.save(vemec);
	
	@PostMapping("/")
	public ResponseEntity<Object> savePersona(@Valid @RequestBody PersonaPropietario data){
		try {
			if (!_persona.Entity(data.getDocumento()).isEmpty()){
				return new ResponseEntity<Object>("No se puede poner dos usuarios con el mismo id: "+data.getDocumento(), HttpStatus.NOT_FOUND);
			}
			PersonaPropietario nuevaPersona = _persona.Save(data);
			return new ResponseEntity<Object>(nuevaPersona, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
			
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") String id){
		try {
			PersonaPropietario pp = _persona.Entity(id).get();
			if (pp == null){
				return new ResponseEntity<Object>("No existe el Propietario con "+id, HttpStatus.NOT_FOUND);
			}
			_persona.Delete(id);
			return new ResponseEntity<Object>(pp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}