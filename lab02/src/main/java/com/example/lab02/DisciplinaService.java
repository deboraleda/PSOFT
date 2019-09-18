package com.example.lab02;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class DisciplinaService {
	//private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	//private int id = 0; 
	
	@PostConstruct
	public void initDisciplinas() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/disciplinas.json");
		try {
			List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference); 
			if(!disciplinaRepository.equals(disciplinas)) {
				this.disciplinaRepository.save(disciplinas);
				System.out.println("Disciplinas salvas no bd");
			}
		}catch (IOException e) {
			System.out.println("Nao foi possivel salvar as disciplinas" + e.getMessage());
		}
		
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinaRepository.getDisciplinas();
	}

	//public void setDisciplina(Disciplina novaDisciplina) {
		//disciplinaRepository.setDisciplina(novaDisciplina);
	//}
	
	public Disciplina getDisciplina(int id) {
		return disciplinaRepository.getDisciplina(id);
	}
	
	public List<Disciplina> getRanking() {
		return disciplinaRepository.getRanking();
	}
	
	public Disciplina atualizaDisciplina(String nome, int id) {
		return disciplinaRepository.atualizaDisciplina(nome, id);
	}
	
	public Disciplina atualizaNota(double nota, int id) {
		return disciplinaRepository.atualizaNota(nota, id);
	}
	
	public Disciplina deletaDisciplina(int id) {
		return disciplinaRepository.deletaDisciplina(id);
	}
	
	
	
	
}
