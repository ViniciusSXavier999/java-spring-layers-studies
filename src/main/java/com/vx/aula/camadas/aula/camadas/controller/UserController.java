package com.vx.aula.camadas.aula.camadas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vx.aula.camadas.aula.camadas.dto.UserDTO;
import com.vx.aula.camadas.aula.camadas.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public UserDTO findById( @PathVariable Long id) {
		return service.buscaId(id);
	}
}
