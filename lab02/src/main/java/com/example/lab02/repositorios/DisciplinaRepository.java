package com.example.lab02.repositorios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab02.entidades.Disciplina;

@Repository
public interface DisciplinaRepository<T, ID> extends JpaRepository<Disciplina, Integer>{


	/*public List<Disciplina> getRanking() {
		disciplinas.sort(comparaDisciplina);
		return disciplinas;
	}*/
	
}
