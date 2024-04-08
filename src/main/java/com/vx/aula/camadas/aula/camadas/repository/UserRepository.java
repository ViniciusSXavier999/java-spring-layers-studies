package com.vx.aula.camadas.aula.camadas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vx.aula.camadas.aula.camadas.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
