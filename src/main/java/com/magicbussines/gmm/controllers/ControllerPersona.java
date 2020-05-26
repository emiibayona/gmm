package com.magicbussines.gmm.controllers;

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

import com.magicbussines.gmm.interfaces.IPersonaInquilino;
import com.magicbussines.gmm.interfaces.IPersonaPropietario;
import com.magicbussines.gmm.interfaces.IPersonaUsuario;
import com.magicbussines.gmm.model.PersonaInquilino;
import com.magicbussines.gmm.model.PersonaPropietario;
import com.magicbussines.gmm.model.PersonaUsuario;

@RestController
@RequestMapping("/persona")
public class ControllerPersona {

	@Autowired
	private IPersonaPropietario _propietario;
	@Autowired
	private IPersonaInquilino _inqulino;
	@Autowired
	private IPersonaUsuario _usuario;
	
	
	// ***********************************************************************************************************************
	// ================================= SECCION DEL CONTROLADOR PARA PERSONA_PROPIETARIO =================================== 
	// ***********************************************************************************************************************
	@GetMapping("/propietario/")
	public ResponseEntity<Object> PropietarioList() {
		List<PersonaPropietario> propietarios = (List<PersonaPropietario>) _propietario.List();
		if(propietarios.isEmpty()) {
			return new ResponseEntity<Object>("FALLO", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(propietarios,HttpStatus.OK);
	}
	
	@PostMapping("/propietario/")
	public ResponseEntity<Object> savePropietario(@Valid @RequestBody PersonaPropietario data){
		if (_propietario.Entity(data.getDocumento()).isPresent()){
			return new ResponseEntity<Object>("No se puede poner dos usuarios con el mismo id: "+data.getDocumento(), HttpStatus.NOT_FOUND);
		}
		try {
			
			PersonaPropietario nuevaPersona = _propietario.savePropietario(data);
			return new ResponseEntity<Object>(nuevaPersona, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}	
	
	@DeleteMapping("/propietario/{id}")
	public ResponseEntity<Object> deletePropietario(@PathVariable(value = "id") String id){
		try {
			PersonaPropietario pp = _propietario.Entity(id).get();
			if (pp == null){
				return new ResponseEntity<Object>("No existe el Propietario con "+id, HttpStatus.NOT_FOUND);
			}
			_propietario.Delete(id);
			return new ResponseEntity<Object>(pp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// ***********************************************************************************************************************
	// ***********************************************************************************************************************
	// =================================== SECCION DEL CONTROLADOR PARA PERSONA_INQULINO ===================================== 
	// ***********************************************************************************************************************
	// ***********************************************************************************************************************
	
	@GetMapping("/inquilino/")
	public ResponseEntity<Object> InquilinoList() {
		List<PersonaInquilino> inquilinos = (List<PersonaInquilino>) _inqulino.List();
		if(inquilinos.isEmpty()) {
			return new ResponseEntity<Object>("FALLO", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(inquilinos,HttpStatus.OK);
	}
	
	@PostMapping("/inquilino/")
	public ResponseEntity<Object> saveInquilino(@Valid @RequestBody PersonaInquilino data){
		try {
			if (!_inqulino.Entity(data.getDocumento()).isEmpty()){
				return new ResponseEntity<Object>("No se puede poner dos usuarios con el mismo id: "+data.getDocumento(), HttpStatus.NOT_FOUND);
			}
			PersonaInquilino nuevaInquilino = _inqulino.Save(data);
			return new ResponseEntity<Object>(nuevaInquilino, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
			
	}	
	
	@DeleteMapping("/inquilino/{id}")
	public ResponseEntity<Object> deleteInquilino(@PathVariable(value = "id") String id){
		try {
			PersonaInquilino pp = _inqulino.Entity(id).get();
			if (pp == null){
				return new ResponseEntity<Object>("No existe el Propietario con "+id, HttpStatus.NOT_FOUND);
			}
			_inqulino.Delete(id);
			return new ResponseEntity<Object>(pp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// ***********************************************************************************************************************
	// ***********************************************************************************************************************
	// =================================== SECCION DEL CONTROLADOR PARA PERSONA_USUARIO ====================================== 
	// ***********************************************************************************************************************
	// ***********************************************************************************************************************

	@GetMapping("/usuario/")
	public ResponseEntity<Object> UsuarioList() {
		List<PersonaUsuario> usuarios = (List<PersonaUsuario>) _usuario.List();
		if(usuarios.isEmpty()) {
			return new ResponseEntity<Object>("FALLO", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(usuarios,HttpStatus.OK);
	}
	
	@PostMapping("/usuario/")
	public ResponseEntity<Object> saveUsuario(@Valid @RequestBody PersonaUsuario data){
		try {
			if (_usuario.EntityById(data.getDocumento()).isPresent()){
				return new ResponseEntity<Object>("No se puede poner dos usuarios con el mismo id: "+data.getDocumento(), HttpStatus.NOT_FOUND);
			}
			PersonaUsuario nuevoUsuario = _usuario.Save(data);
			return new ResponseEntity<Object>(nuevoUsuario, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
			
	}	
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") String id){
		try {
			PersonaUsuario user = _usuario.EntityById(id).get();
			if (user == null){
				return new ResponseEntity<Object>("No existe el Propietario con "+id, HttpStatus.NOT_FOUND);
			}
			_usuario.Delete(id);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	
}