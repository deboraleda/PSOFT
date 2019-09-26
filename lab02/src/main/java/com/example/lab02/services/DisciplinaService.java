package com.example.lab02.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.lab02.entidades.Disciplina;
import com.example.lab02.repositorios.DisciplinaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class DisciplinaService {
	
	private DisciplinaRepository<Disciplina, Integer> disciplinaRepository;
	
	public DisciplinaService(DisciplinaRepository<Disciplina, Integer> disciplinaRepository) {
		super();
		this.disciplinaRepository = disciplinaRepository;
	}

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
		return (Disciplina) disciplinaRepository.findById(id);
	}
	
	public Disciplina adicionaLike(int id) {
		disciplinaRepository.findById(id).adicionaLike();
		return disciplinaRepository.save(disciplinaRepository.findById(id));
	}
	
	public Disciplina atualizaNota(double nota, int id) {
		disciplinaRepository.findById(id).atualizaNota(nota);
		return disciplinaRepository.save(disciplinaRepository.findById(id));
	}
	
	public Disciplina adicionaComentario(int id, String comentario) {
		disciplinaRepository.findById(id).adicionaComentario(comentario);
		return disciplinaRepository.save(disciplinaRepository.findById(id));
	}
	
	public List<Disciplina> getRankingNotas() {
		return disciplinaRepository.findAllByNota();
	}
	
	public List<Disciplina> getRankingLikes() {
		return disciplinaRepository.findAllByLikes();
	}
	
	public Disciplina deletaDisciplina(int id) {
		Disciplina retorno = (Disciplina) disciplinaRepository.findById(id);
		disciplinaRepository.deleteById(id);
		return retorno;
	}
	
}
