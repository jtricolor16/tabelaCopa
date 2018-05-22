package br.com.tabelaCopa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.entities.Pais;
import br.com.tabelaCopa.repositories.JogadorRepository;
import br.com.tabelaCopa.repositories.PaisRepository;
import br.com.tabelaCopa.validations.JogadorValidation;

@Service
public class JogadorService {
	
	private JogadorRepository jogadorRepository;
	private PaisRepository paisRepository;
	
	@Autowired
	public JogadorService(JogadorRepository jogadorRepository, PaisRepository paisRepository){
		this.jogadorRepository=jogadorRepository;
		this.paisRepository=paisRepository;
	}
	
	public boolean salvar(Jogador jogador){
		if(new JogadorValidation().validarJogador(this.jogadorRepository, jogador.getCpf(), jogador.getRg())==true){
			Pais pais = this.paisRepository.findByNome(jogador.getNacionalidade().getNome());
			jogador.setNacionalidade(pais);
			this.jogadorRepository.save(jogador);
			return true;
		}
		return false;
	}
	
	public Iterable<Jogador> listar(){
		return this.jogadorRepository.findAll();
	}
	
	
	
	
}
