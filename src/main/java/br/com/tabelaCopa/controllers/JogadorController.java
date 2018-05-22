package br.com.tabelaCopa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.requestBodies.JogadorRequestBody;
import br.com.tabelaCopa.services.JogadorService;

@RestController
public class JogadorController {
	
	private JogadorService jogadorService;
	
	@Autowired
	public JogadorController(JogadorService jogadorService){
		this.jogadorService=jogadorService;
	}
	
	@PostMapping("/jogador/salvar")
	public boolean salvar(@RequestBody JogadorRequestBody requestBody){
		return jogadorService.salvar(new Jogador(requestBody));
	}
	
//	public boolean editar(){
//		
//	}
//	
//	public boolean excluir(){
//		
//	}
//	
	@GetMapping("/jogadores")
	public Iterable<Jogador> listar(){
		return jogadorService.listar();
	}
//	
//	public List<Jogador> listarPorPais(){
//		
//	}
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
