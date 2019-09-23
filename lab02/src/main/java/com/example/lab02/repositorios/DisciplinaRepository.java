package com.example.lab02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class DisciplinaRepository {

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private Comparator comparaDisciplina;
	
	public void save(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void setDisciplina(Disciplina novaDisciplina) {
		this.disciplinas.add(new Disciplina(novaDisciplina.getNome(), novaDisciplina.getNota()));
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public Disciplina getDisciplina(int id) {
		return disciplinas.get(id);
	}
	
	public List<Disciplina> getRanking() {
		disciplinas.sort(comparaDisciplina);
		return disciplinas;
	}
	
	public Disciplina atualizaDisciplina(String nome, int id) {
		disciplinas.get(id).atualizaDisciplina(nome);
		return disciplinas.get(id);
	}
	
	public Disciplina atualizaNota(double nota, int id) {
		disciplinas.get(id).atualizaNota(nota);
		return disciplinas.get(id);
	}
	
	public Disciplina deletaDisciplina(int id) {
		Disciplina deletada = disciplinas.get(id);
		return disciplinas.remove(id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisciplinaRepository other = (DisciplinaRepository) obj;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		return true;
	}
	
	
	
}
