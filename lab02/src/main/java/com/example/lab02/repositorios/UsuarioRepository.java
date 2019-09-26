package com.example.lab02.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab02.entidades.Usuario;

//bd de usuarios

@Repository
public interface UsuarioRepository<T, ID extends Serializable> extends JpaRepository<Usuario, String>{

	//@Query()
	Usuario findByEmail(String email);
}
