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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magicbussines.gmm.interfaces.INotas;
import com.magicbussines.gmm.interfaces.IPersonaInquilino;
import com.magicbussines.gmm.interfaces.IPersonaUsuario;
import com.magicbussines.gmm.model.Nota;

@RestController
@RequestMapping("/nota")
public class ControllerNotas {
	
	@Autowired
	private INotas _nota;
	@Autowired
	private IPersonaUsuario _usuario;
	@Autowired
	private ObjectMapper objectMapper;
			
	@GetMapping("/")
	public ResponseEntity<Object> notaLista() {
		List<Nota> notas = (List<Nota>) _nota.List();
		if(notas.isEmpty()) {
			return new ResponseEntity<Object>("No hay notas en el sistema", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(notas,HttpStatus.OK);
	}
	
	@GetMapping("/{documento}")
	public ResponseEntity<Object> notaListaByUser(@PathVariable(value = "documento") String documento) {
		List<Nota> notas = (List<Nota>) _nota.listaNotasByUsuario(documento);
		if(notas.isEmpty()) {
			return new ResponseEntity<Object>("No hay notas en el sistema para el usurio con Documento "+documento, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(notas,HttpStatus.OK);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Object> saveNota(@RequestBody JsonNode data) throws JsonParseException, JsonMappingException, IOException{
		try {
			Nota nuevaNota = new Nota();
			//nuevaNota = objectMapper.readValue(data.get("nota").toString(),Nota.class);
			nuevaNota.setTitulo(data.get("nota").get("titulo").asText());
			nuevaNota.setTexto(data.get("nota").get("texto").asText());
			nuevaNota.setUsuario((_usuario.Entity(data.get("user").get("login").asText(), data.get("user").get("password").asText()).get()));
			nuevaNota = _nota.Save(nuevaNota);
			return new ResponseEntity<Object>(nuevaNota, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteNota(@PathVariable(value = "id") Integer id){
		try {
			Nota nota = _nota.Entity(id).get();
			if (nota == null){
				return new ResponseEntity<Object>("No existe el Propietario con "+id, HttpStatus.NOT_FOUND);
			}
			_nota.Delete(id);
			return new ResponseEntity<Object>(nota, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
