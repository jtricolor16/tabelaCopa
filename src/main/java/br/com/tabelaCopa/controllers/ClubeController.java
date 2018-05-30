package br.com.tabelaCopa.controllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tabelaCopa.entities.Clube;
import br.com.tabelaCopa.requestBodies.ClubeRequestBody;
import br.com.tabelaCopa.services.ClubeService;

@RestController
public class ClubeController {
	
	private ClubeService clubeService;
	private ServletContext context;
	
	@Autowired
	public ClubeController(ClubeService clubeService, ServletContext context){
		this.clubeService=clubeService;
		this.context=context;
	}
	
	@PostMapping("/clube/salvar")
	public ResponseEntity<Boolean> salvar(@RequestBody ClubeRequestBody clubeRequestBody){
		return ResponseEntity.ok(this.clubeService.save(context, new Clube(clubeRequestBody)));
	}
	
	@PutMapping("/clube/editar")
	public ResponseEntity<Boolean> editar(@RequestBody ClubeRequestBody clubeRequestBody){
		return ResponseEntity.ok(this.clubeService.editar(context, new Clube(clubeRequestBody)));
	}
	
	@DeleteMapping("/clube/deletar/{id}")
	public ResponseEntity<Boolean> deletar(@PathVariable Long id){
		return ResponseEntity.ok(this.clubeService.delete(id));
	}
	
	@GetMapping("/clubes")
	public ResponseEntity<Iterable<Clube>> listar(){
		return ResponseEntity.ok(this.clubeService.listar());
	}
	
	@GetMapping("/clube/registro/{registro}")
	public ResponseEntity<Clube>buscarPorRegistro(@PathVariable Long registro){
		return ResponseEntity.ok(this.clubeService.buscaClubePorRegistro(registro));
	}
}
