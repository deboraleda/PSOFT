package com.example.lab02.controladores;

import java.util.List;

import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab02.entidades.Disciplina;
import com.example.lab02.services.DisciplinaService;


@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService dservice;
	
	//retorna todas as disciplinas
	@RequestMapping("/v1/api/disciplinas")
	public ResponseEntity<List<Disciplina>> getDisciplinas(@RequestHeader("Authorization") String header) throws ServletException{
		return new ResponseEntity<List<Disciplina>>(dservice.getDisciplinas(), HttpStatus.OK);
	}
	
	//retorna uma disciplina com o id passado 
	@RequestMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplina(@RequestHeader("Authorization")String header, @RequestParam(value = "id") int id) throws ServletException{
		if(dservice.getDisciplina(id) != null)
			return new ResponseEntity<Disciplina>(dservice.getDisciplina(id), HttpStatus.OK);
		return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);	
	}
	
	//atualiza o numero de likes de uma disciplina
	@PutMapping("/api/disciplinas/likes/{id}")
	public ResponseEntity<Disciplina> adicionaLike(@RequestParam int id, @RequestHeader("Authorization") String header){
		if(dservice.adicionaLike(id) != null) 
			return new ResponseEntity<Disciplina>(dservice.getDisciplina(id), HttpStatus.OK);
		return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/disciplinas/nota/{id}")
	public ResponseEntity<Disciplina> atualizaNota(@RequestParam int id, @RequestHeader("Authorization") String header, @RequestBody Disciplina novaNota){
		if(dservice.atualizaNota(novaNota.getNota(), id) != null)
			return new ResponseEntity<Disciplina>(dservice.getDisciplina(id), HttpStatus.OK);
		return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/disciplinas/comentarios/{id}")
	public ResponseEntity<Disciplina> adicionaComentario(@RequestParam int id, @RequestHeader("Authorization") String header, @RequestBody Disciplina comentario){
		if(dservice.adicionaComentario(id, comentario.getComentarios()) != null)
			return new ResponseEntity<Disciplina>(dservice.getDisciplina(id), HttpStatus.OK);
		return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/api/disciplinas/ranking/notas")
	public ResponseEntity<List<Disciplina>> getRankingNotas(){
		return new ResponseEntity<List<Disciplina>>(dservice.getRankingNotas(), HttpStatus.OK);
	}
	
	@RequestMapping("/api/disciplinas/ranking/likes")
	public ResponseEntity<List<Disciplina>> getRankingLikes(){
		return new ResponseEntity<List<Disciplina>>(dservice.getRankingLikes(), HttpStatus.OK);
	}
	
}


