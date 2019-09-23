package com.example.lab02;


import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
	
	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	public void setUsuario(Usuario usuario) {
		usuarios.put(usuario.getEmail(), usuario);
	}

	public Usuario getUsuario(String email) {
		return usuarios.get(email);
	}
	
	public Usuario deletaUsuario(String email) {
		return usuarios.remove(email);
	}
	
}
