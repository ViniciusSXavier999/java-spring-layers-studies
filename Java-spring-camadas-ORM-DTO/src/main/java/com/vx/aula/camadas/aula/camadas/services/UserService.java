package com.vx.aula.camadas.aula.camadas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vx.aula.camadas.aula.camadas.dto.UserDTO;
import com.vx.aula.camadas.aula.camadas.entities.User;
import com.vx.aula.camadas.aula.camadas.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public UserDTO buscaId(Long id) {
		
		/*O meu repository trabalha com entity que é o USER*/
		
		User entity =  repository.findById(id).get();
		
		/*PORÉM QUEREMOS RETORNAR UM DTO*/
		// transformando o User para Userdto
		UserDTO dto = new UserDTO(entity);
		return dto;
	}

}
