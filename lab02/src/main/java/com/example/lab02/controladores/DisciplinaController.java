package com.example.lab02.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab02.entidades.Disciplina;
import com.example.lab02.services.DisciplinaService;
import com.example.lab02.services.JWTService;
import com.example.lab02.services.UsuarioService;


@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService dservice;
	
	
	@RequestMapping("/v1/api/disciplinas")
	public ResponseEntity<List<Disciplina>> getDisciplinas(){
		return new ResponseEntity<List<Disciplina>>(dservice.getDisciplinas(), HttpStatus.OK);
	}
	
	
	
	/*//login de usuario
	@PostMapping("/auth/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(authenthicate(uservice), HttpStatus.OK);
	}*/
	
	@RequestMapping("/v1/api/disciplinas/")
	public ResponseEntity<Disciplina> getDisciplina(@RequestParam(value = "id") int id){
		return new ResponseEntity<Disciplina>(dservice.getDisciplina(id), HttpStatus.OK);
	}
	
	
	/*@RequestMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<ArrayList<Disciplina>> getRanking(){
		return new ResponseEntity<List<Disciplina>>(dservice.getRanking(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> setNovaSaudacao(@RequestBody Disciplina novaDisciplina) {
		return new ResponseEntity<Disciplina>(dservice.setDisciplina(novaDisciplina), HttpStatus.CREATED);
	}
	
	@PostMapping("/v1/auth/usuarios")
	public ResponseEntity<Disciplina> setNovoUsusario(@RequestBody Disciplina novaDisciplina) {
		return new ResponseEntity<Disciplina>(dservice.setDisciplina(novaDisciplina), HttpStatus.CREATED);
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atualizaDisciplina(@PathVariable int id, @PathVariable String nome) {
		return new ResponseEntity<Disciplina>(dservice.atualizaDisciplina(nome, id), HttpStatus.OK);
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> atualizaDisciplinaNota(@PathVariable int id, @PathVariable String nota) {
		return new ResponseEntity<Disciplina>(dservice.atualizaDisciplina(nota, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> deletaDisciplina(@PathVariable int id) {
		return new ResponseEntity<Disciplina>(dservice.deletaDisciplina(id), HttpStatus.OK);
	}*/
	
}


