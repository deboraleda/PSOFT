package com.example.lab02.entidades;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Disciplina{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double nota;
	private String comentarios = "";
	private int likes = 0;

	public Disciplina(String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}
	
	public Disciplina() {
	
	}
	
	public Disciplina(@JsonProperty("nome") String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", nota=" + nota + "]";
	}

	public double getNota() {
		return nota;
	}
	
	public int getId() {
		return id;
	}
	
	public String getComentarios() {
		return comentarios;
	}
	
	public int getLikes() {
		return likes;
	}

	public String getNome() {
		return nome;
	}
	
	public void atualizaDisciplina(String nome) {
		this.nome = nome;
	}
	
	public void atualizaNota(double nota) {
		this.nota = nota;
	}
	
	public void adicionaComentario(String comentario) {
		this.comentarios += (comentario + "\n");
	}
	
	public void adicionaLike() {
		this.likes++;
	}
}
