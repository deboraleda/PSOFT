package com.example.lab02.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab02.comparators.ComparaPorLike;
import com.example.lab02.entidades.Disciplina;
import com.example.lab02.repositorios.DisciplinaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository<Disciplina, Integer> disciplinaRepository;
	private ComparaPorLike comparaPorLike = new ComparaPorLike();
	
	//private int id = 0; 
	
	@PostConstruct
	public void initDisciplinas() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/disciplinas.json");
		try {
			List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference); 
			if(disciplinaRepository.count() != disciplinas.size()) {
				this.disciplinaRepository.saveAll(disciplinas);
				System.out.println("Disciplinas salvas no bd");
			}
		}catch (IOException e) {
			System.out.println("Nao foi possivel salvar as disciplinas" + e.getMessage());
		}
		
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinaRepository.findAll();
	}
	
	public Disciplina getDisciplina(int id) {
		return (Disciplina) disciplinaRepository.getOne(id);
	}
	
	public Disciplina adicionaLike(int id) {
		disciplinaRepository.getOne(id).adicionaLike();
		return disciplinaRepository.getOne(id);
	}
	
	public Disciplina atualizaNota(double nota, int id) {
		disciplinaRepository.getOne(id).atualizaNota(nota);
		return disciplinaRepository.getOne(id);
	}
	
	public Disciplina adicionaComentario(int id, String comentario) {
		disciplinaRepository.getOne(id).adicionaComentario(comentario);
		return disciplinaRepository.getOne(id);
	}
	
	public List<Disciplina> getRankingNotas() {
		List<Disciplina> disciplinas = disciplinaRepository.findAll();
		Collections.sort(disciplinas);
		return disciplinas;
	}
	
	public List<Disciplina> getRankingLikes() {
		List<Disciplina> disciplinas = disciplinaRepository.findAll();
		Collections.sort(disciplinas, comparaPorLike);
		return disciplinas;
	}
	
	/**/
	
	/*public Disciplina atualizaDisciplina(String nome, int id) {
		return disciplinaRepository.atualizaDisciplina(nome, id);
	}
	
	*/
	
	public Disciplina deletaDisciplina(int id) {
		Disciplina retorno = (Disciplina) disciplinaRepository.getOne(id);
		disciplinaRepository.deleteById(id);
		return retorno;
	}
	
	
	
	
}
