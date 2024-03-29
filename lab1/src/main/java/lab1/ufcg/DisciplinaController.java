package lab1.ufcg;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService dservice;
	
	@RequestMapping("/v1/api/disciplinas")
	public ResponseEntity<ArrayList<Disciplina>> getDisciplinas(){
		return new ResponseEntity<ArrayList<Disciplina>>(dservice.getDisciplinas(), HttpStatus.OK);
	}
	
	@RequestMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplina(@PathVariable("id") int id){
		return new ResponseEntity<Disciplina>(dservice.getDisciplina(id), HttpStatus.OK);
	}
	
	@RequestMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<ArrayList<Disciplina>> getRanking(){
		return new ResponseEntity<ArrayList<Disciplina>>(dservice.getRanking(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> setNovaSaudacao(@RequestBody Disciplina novaDisciplina) {
		return new ResponseEntity<Disciplina>(dservice.setDisciplina(novaDisciplina), HttpStatus.CREATED);
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atualizaDisciplina(@PathVariable("id") int id, @RequestBody String novoNome) {
		return new ResponseEntity<Disciplina>(dservice.atualizaDisciplina(novoNome, id), HttpStatus.OK);
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> atualizaDisciplinaNota(@PathVariable("id") int id, @RequestBody double novaNota) {
		return new ResponseEntity<Disciplina>(dservice.atualizaNota(novaNota, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> deletaDisciplina(@PathVariable int id) {
		return new ResponseEntity<Disciplina>(dservice.deletaDisciplina(id), HttpStatus.OK);
	}
	
}


