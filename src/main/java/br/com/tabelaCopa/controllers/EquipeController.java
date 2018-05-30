package br.com.tabelaCopa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tabelaCopa.entities.Equipe;
import br.com.tabelaCopa.requestBodies.EquipeRequestBody;
import br.com.tabelaCopa.services.EquipeService;

@RestController
public class EquipeController {

	private EquipeService equipeService;
	
	@Autowired
	public EquipeController(EquipeService equipeService){
		this.equipeService=equipeService;
	}
	
	@PostMapping("/equipe/salvar")
	public ResponseEntity<Boolean> salvar(@RequestBody EquipeRequestBody equipeRequestBody){
		return ResponseEntity.ok(this.equipeService.criarEquipe(new Equipe(equipeRequestBody)));
	}
	
	@PutMapping("/equipe/adicionarJogadorAEquipe/{idEquipe}/{idJogador}")
	public ResponseEntity<Boolean>adicionarJogadorAEquipe(@PathVariable Long idEquipe, @PathVariable Long idJogador){
		return ResponseEntity.ok(this.equipeService.adicionarJogadorAEquipe(idEquipe, idJogador));
	}
	
	@PutMapping("/equipe/removerJogadorDaEquipe/{idEquipe}/{idJogador}")
	public ResponseEntity<Boolean>removerJogadorDaEquipe(@PathVariable Long idEquipe, @PathVariable Long idJogador){
		return ResponseEntity.ok(this.equipeService.removerJogadorDaEquipe(idEquipe, idJogador));
	}
	
	
}
