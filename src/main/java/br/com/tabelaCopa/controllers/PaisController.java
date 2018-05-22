package br.com.tabelaCopa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tabelaCopa.entities.Pais;
import br.com.tabelaCopa.requestBodies.PaisRequestBody;
import br.com.tabelaCopa.services.PaisService;

@RestController
public class PaisController {
	
	private PaisService paisService;
	
	@Autowired
	public PaisController(PaisService paisService){
		this.paisService=paisService;
	}
	
	@PostMapping("/pais/salvar")
	public boolean salvar(@RequestBody PaisRequestBody requestBody){
		return paisService.salvar(new Pais(requestBody));
	}
	
	@GetMapping("/paises")
	public List<Pais> listar(){
		return paisService.listar();
	}
	
	@GetMapping("/pais/{nome}")
	public Pais getPaisByNome(@PathVariable String nome){
		return paisService.findPaisByName(nome);
	}
	
	@DeleteMapping("/pais/deletar/{id}")
	public boolean deletar(@PathVariable Long id){
		return paisService.deletar(id);
	}
	
	@PutMapping("/pais/editar")
	public boolean editar(@RequestBody PaisRequestBody requestBody){
		return paisService.editar(requestBody.id, requestBody.nome);
	}
	
}
