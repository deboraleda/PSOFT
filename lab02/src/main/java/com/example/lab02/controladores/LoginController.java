package com.example.lab02.controladores;

import java.sql.Date;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab02.entidades.Usuario;
import com.example.lab02.services.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	
	private final String TOKEN_KEY = "login valido";
	
	private UsuarioService uservice;
	
	public LoginController(UsuarioService uservice) {
		this.uservice = uservice;
	}

	@PostMapping("/auth/login")
	public LoginResponse authenthicate(@RequestBody Usuario usuario) throws ServletException {
		//recuperar usuario
		Usuario authUsuario = uservice.getUsuario(usuario.getEmail());
		
		if(authUsuario == null) {
			throw new ServletException("usuario nao encontrado");
		}
		
		verificaSenha(authUsuario, usuario);
		
		String token = geraToken(authUsuario.getEmail());
		
		return new LoginResponse(token);
		
	}
	
	private void verificaSenha(Usuario authUsuario, Usuario usuario) throws ServletException{
		if(!authUsuario.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("senha invalida");
		}
	}
	
	private String geraToken(String email) throws ServletException{
		return Jwts.builder().setSubject(email).signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + 1 *60 * 10000)).compact();
	}
	
	private class LoginResponse{
		public String token;
		
		public LoginResponse(String token) {
			this.token = token;
		}
	}
	
}
