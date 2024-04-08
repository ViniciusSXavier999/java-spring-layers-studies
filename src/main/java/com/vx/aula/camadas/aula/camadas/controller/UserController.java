package com.vx.aula.camadas.aula.camadas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vx.aula.camadas.aula.camadas.dto.UserDTO;
import com.vx.aula.camadas.aula.camadas.entities.User;
import com.vx.aula.camadas.aula.camadas.exception.ServiceException;
import com.vx.aula.camadas.aula.camadas.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll (){
		List<UserDTO> list = service.findAll();	
		return ResponseEntity.status(HttpStatus.OK).body(list);
	
		
	}
	
	@GetMapping(value = "/{id}")
	public UserDTO findById( @PathVariable Long id) {
		return service.buscaId(id);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		
		try {
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		} 
		catch (ServiceException e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
	}
}
