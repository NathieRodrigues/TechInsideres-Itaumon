package br.com.itau.dashboard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.dashboard.dao.AlarmeDAO;
import br.com.itau.dashboard.model.Alarme;

@CrossOrigin("*")
@RestController
public class AlarmeController {

	@Autowired
	private AlarmeDAO dao;
	
	@GetMapping("/alarmes")
	public ResponseEntity<ArrayList<Alarme>> listaAlarme(){
		ArrayList<Alarme> lista = (ArrayList<Alarme>) dao.findAll();
		if(lista.size()==0) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	
}
