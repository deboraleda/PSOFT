package com.example.lab02.services;


import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.example.lab02.entidades.Usuario;
import com.example.lab02.repositorios.UsuarioRepository;


@Service
public class UsuarioService {
	
	private UsuarioRepository usuarios;
	
	public void setUsuario(Usuario usuario) {
		usuarios.save(usuario);
	}

	public Usuario getUsuario(String email) {
		return (Usuario) usuarios.getOne(email);
	}
	
	public Usuario deletaUsuario(String email) {
		Usuario retorno = (Usuario) usuarios.getOne(email);
		usuarios.deleteById(email);
		return retorno;
	}
	
}
