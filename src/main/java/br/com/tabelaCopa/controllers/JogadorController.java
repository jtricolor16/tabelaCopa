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

import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.requestBodies.JogadorRequestBody;
import br.com.tabelaCopa.services.JogadorService;

@RestController
public class JogadorController {
	
	private JogadorService jogadorService;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	public JogadorController(JogadorService jogadorService){
		this.jogadorService=jogadorService;
	}
	
	@PostMapping("/jogador/salvar")
	public boolean salvar(@RequestBody JogadorRequestBody requestBody){
		return jogadorService.salvar(context, new Jogador(requestBody));
	}
	
	@PutMapping("/jogador/editar")
	public ResponseEntity<Boolean> editar(@RequestBody JogadorRequestBody requestBody){
		return ResponseEntity.ok(jogadorService.editar(context, new Jogador(requestBody)));
	}
//	
	@DeleteMapping("/jogador/delete/{id}")
	public ResponseEntity<Boolean> deletar(@PathVariable Long id){
		return ResponseEntity.ok(jogadorService.deletar(context, id));
	}
	
	@GetMapping("/jogadores")
	public Iterable<Jogador> listar(){
		return jogadorService.listar();
	}
	
	@GetMapping("/jogador/pais/{id}")
	public Iterable<Jogador> listarPorPais(@PathVariable Long id){
		return jogadorService.listarJogadorPorPais(id);
	}
	
//	
//	public Jogador buscarJogadorPorId(){
//		
//	}
//	
//	public List<Jogador>listarJogadorPorNome(){
//		
//	}
//	
//	public Jogador buscarJogadorPorCpf(){
//		
//	}
//	
//	public Jogador buscarJogadorPorRg(){
//		
//	}
}
