package com.example.lab02;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Service
public class JWTService {
	private UsuarioService uservice;

	public JWTService(UsuarioService uservice) {
		super();
		this.uservice = uservice;
	}
	
	public boolean usuarioExiste(String authorizationHeader) throws ServletException {
		String usuario = getSujeitoDoToken(authorizationHeader);
		return uservice.getUsuario(usuario) != null ;
	}
	
	public boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
		String sujeito = getSujeitoDoToken(authorizationHeader);
		Usuario user = uservice.getUsuario(sujeito);
		
		return user != null && user.getEmail().equals(email);
	}
	
	//authorizationHeader contem o token do usuario passado no http, retorna o email dele
	private String getSujeitoDoToken(String authorizationHeader) throws ServletException {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou mal formatado!");
		}

		// Extraindo apenas o token do cabecalho.
		String token = authorizationHeader.substring(com.example.lab02.TokenFilter.TOKEN_INDEX);

		String subject = null;
		try {
			subject = Jwts.parser().setSigningKey("login valido").parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
			throw new ServletException("Token invalido ou expirado!");
		}
		return subject;
	}
	
	
}
