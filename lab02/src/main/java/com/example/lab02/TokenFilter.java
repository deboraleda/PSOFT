package com.example.lab02;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean{
	public final static int TOKEN_INDEX = 7;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		//extraindo cabecalho
		String header = req.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")) {
			throw new ServletException("Token inexisente ou mal formatado");
		}
		
		//extraindo token do cabecalho
		String token = header.substring(7);
		
		try {
			Jwts.parser().setSigningKey("login valido").parseClaimsJws(token).getBody();
		}catch(SignatureException s) {
			throw new ServletException("token invalido ou expirado");
		}
		
		chain.doFilter(request, response);
	}
}
