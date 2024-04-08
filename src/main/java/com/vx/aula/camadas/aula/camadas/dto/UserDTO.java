package com.vx.aula.camadas.aula.camadas.dto;

import com.vx.aula.camadas.aula.camadas.entities.User;

// objeto para trafegar dados!
public class UserDTO {

	private Long id;
	private String name;
	private String password;

	public UserDTO() {

	}

	public UserDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// fazendo a conversão de user para DTO
	public UserDTO(User user) {
		// copiando os dados de user para userDTO através do método GET.
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
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
