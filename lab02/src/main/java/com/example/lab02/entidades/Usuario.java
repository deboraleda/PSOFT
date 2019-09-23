package com.example.lab02.entidades;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {
	@Id
	private String email;
	private String nome;
	private String senha;
	
	
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}	
	
	/*public Usuario(@JsonProperty("email") String email) {
		super();
		this.email = email;
	}*/
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
}
