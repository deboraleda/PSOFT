package lab1.ufcg;

import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class DisciplinaService {
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private Comparator<Disciplina> comparaDisciplina;
	private int id = 0; 

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Disciplina setDisciplina(Disciplina novaDisciplina) {
		this.disciplinas.add(new Disciplina(id, novaDisciplina.getNome(), novaDisciplina.getNota()));
		return disciplinas.get(id++);
	}
	
	public Disciplina getDisciplina(int id) {
		if(id <= this.id)
			return disciplinas.get(id);
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
	}
	
	public ArrayList<Disciplina> getRanking() {
		disciplinas.sort(comparaDisciplina);
		return disciplinas;
	}
	
	public Disciplina atualizaDisciplina(String nome, int id) {
		if(id <= this.id) {
			disciplinas.get(id).atualizaDisciplina(nome);
			return disciplinas.get(id);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
	}
	
	public Disciplina atualizaNota(double nota, int id) {
		if(id <= this.id) {
			disciplinas.get(id).atualizaNota(nota);
			return disciplinas.get(id);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
	}
	
	public Disciplina deletaDisciplina(int id) {
		if(id <= this.id) {
			Disciplina deletada = disciplinas.get(id);
			return disciplinas.remove(id);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
	}
	
	
	
	
}
