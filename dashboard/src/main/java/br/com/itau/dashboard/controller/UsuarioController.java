package br.com.itau.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.dashboard.dao.UsuarioDAO;
import br.com.itau.dashboard.model.Usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> efetuarLogin(@RequestBody Usuario usuario){	
		Usuario objeto = dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		if (objeto==null) {
			Usuario objeto2 = dao.findByRacfAndSenha(usuario.getRacf(), usuario.getSenha());
			if(objeto2==null) {
				return ResponseEntity.status(403).build();
			}else 
				return ResponseEntity.ok(objeto2);
		}else {
			return ResponseEntity.ok(objeto);
		}
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioId(@PathVariable int id){
		Usuario resposta = dao.findById(id).orElse(null);
		if (resposta==null) {
			return ResponseEntity.status(404).build();
		}else {
			return ResponseEntity.ok(resposta);
		}
	}
	
	
}
