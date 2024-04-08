package com.vx.aula.camadas.aula.camadas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vx.aula.camadas.aula.camadas.dto.UserDTO;
import com.vx.aula.camadas.aula.camadas.entities.User;
import com.vx.aula.camadas.aula.camadas.exception.ServiceException;
import com.vx.aula.camadas.aula.camadas.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public List<UserDTO> findAll() {
		
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	
	
	public UserDTO buscaId(Long id) {
		
		/*O meu repository trabalha com entity que é o USER*/
		
		User entity =  repository.findById(id).get();
		
		/*PORÉM QUEREMOS RETORNAR UM DTO*/
		// transformando o User para Userdto
		UserDTO dto = new UserDTO(entity);
		return dto;
	}
	
	
	public User insert(User entity) {
		User user = repository.findByEmail(entity.getEmail());
		
		if(user != null) {
			throw new ServiceException("Email já existe");
		}
		
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		return repository.save(entity);
	}
	
	
	

}
