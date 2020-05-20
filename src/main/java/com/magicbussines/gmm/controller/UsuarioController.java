package com.magicbussines.gmm.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.magicbussines.gmm.interfaceServices.IUsuarioService;
import com.magicbussines.gmm.models.Usuario;

@Controller
@RequestMapping
public class UsuarioController {
	
	@Autowired
	private IUsuarioService userService;
	
	@GetMapping("/")
	public String listar(Model model) {
		List<Usuario> usuarios = userService.listar();
		model.addAttribute("usuarios",usuarios);
		return "listar";
	}
	
	@GetMapping("/agregarGet")
	public String agregarGet(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "agregarUsuario";
	}
	
	@PostMapping("/save")
	public String agregarPost(@Valid Usuario u,Model model) {
		userService.save(u);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{ci}")
	public String editar(@PathVariable long ci, Model model) {
		Optional<Usuario> userupd = userService.listarId(ci);
		model.addAttribute("usuario",userupd);
		return "editarUsuario";
	}
	
	@GetMapping("/borrar/{ci}")
	public String borrar(@PathVariable long ci, Model model) {
		userService.delete(ci);
		return "redirect:/";
	}

}
