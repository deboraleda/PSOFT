package com.example.lab02.controladores;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab02.entidades.Usuario;
import com.example.lab02.services.JWTService;
import com.example.lab02.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService uservice;
	@Autowired
	private JWTService jwtservice;
	
	
	//******************metodos de usuarios*********************
	
		//cria novo usuario
		@PostMapping("/usuarios")
		public void setUsuario(@RequestBody Usuario usuario) {
			uservice.setUsuario(usuario);
		}
		
		//deleta usuario
		@DeleteMapping("/auth/usuarios")
		public ResponseEntity<Usuario> removeUsuario(@RequestHeader("Authorization") String header) throws ServletException{
			if(jwtservice.usuarioExiste(header) == null) {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
			}try {
				Usuario user = jwtservice.usuarioExiste(header); 
				if(jwtservice.usuarioTemPermissao(header, user.getEmail())) {
					return new ResponseEntity<Usuario>(uservice.deletaUsuario(user.getEmail()), HttpStatus.OK);
				}
			}catch(ServletException s){
				//usuario esta com codigo invalido ou vencido
				return new ResponseEntity<Usuario>(HttpStatus.FORBIDDEN);
			}//usuario nao tem permissao
			return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
		}
		
		
		// retorna usuario com o id passado
		@RequestMapping("/auth/usuarios/{email}")
		public ResponseEntity<Usuario> getUsuario(@PathVariable("email") String email){
			Usuario u = uservice.getUsuario(email);
			if(u != null) {
				return new ResponseEntity<Usuario>(u, HttpStatus.OK);
			}
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		
		
		
}
