package com.example.lab02.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab02.entidades.Usuario;

//bd de usuarios

@Repository
public interface UsuarioRepository<T, Id> extends JpaRepository<Usuario, String>{

	
}
