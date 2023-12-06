package com.vx.aula.camadas.aula.camadas.dto;

import com.vx.aula.camadas.aula.camadas.entities.User;

// objeto para trafegar dados!
public class UserDTO {

	private Long id;
	private String name;

	public UserDTO() {

	}

	public UserDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// fazendo a conversão de DTO para user
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
