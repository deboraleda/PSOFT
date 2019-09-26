package com.example.lab02.repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.lab02.entidades.Disciplina;


@Repository
public interface DisciplinaRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Integer>{
	//@Query
	public Disciplina findById(int id);
	
	@Query(value = "select u from Disciplina u order by u.likes DESC, u.id ASC")
	public List<Disciplina> findAllByLikes();
	
	@Query(value = "select u from Disciplina u order by u.nota DESC, u.id ASC")
	public List<Disciplina> findAllByNota();
}
