package br.com.tabelaCopa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tabelaCopa.entities.Clube;
import br.com.tabelaCopa.entities.ClubeJogador;
import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.requestBodies.ClubeJogadorRequestBody;
import br.com.tabelaCopa.services.ClubeJogadorService;

@RestController
public class ClubeJogadorController {
	
	private ClubeJogadorService clubeJogadorService;
	
	@Autowired
	public ClubeJogadorController(ClubeJogadorService clubeJogadorService){
		this.clubeJogadorService=clubeJogadorService;
	}
	
	@PutMapping("clubeJogador/adicionar")
	public ResponseEntity<Boolean> adicionarClubeAoJogador(@RequestBody ClubeJogadorRequestBody requestBody){
		return ResponseEntity.ok(clubeJogadorService.adicionarClubeAoJogador(new ClubeJogador(requestBody)));
	}
	
	@GetMapping("ClubeJogador/exibirJogadoresPorClube/{id}")
	public ResponseEntity<List<Jogador>> listarJogadoresPorClube(@PathVariable Long id){
		return ResponseEntity.ok(this.clubeJogadorService.carregarJogadoresPorClube(id));
	}
	
	@GetMapping("ClubeJogador/exibirClubesPorJogador/{id}")
	public ResponseEntity<List<Clube>> listarClubesPorJogador(@PathVariable Long id){
		return ResponseEntity.ok(this.clubeJogadorService.carregarClubesPorJogador(id));
	}
}
