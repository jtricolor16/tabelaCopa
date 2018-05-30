package br.com.tabelaCopa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tabelaCopa.entities.Equipe;
import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.repositories.EquipeRepository;
import br.com.tabelaCopa.repositories.JogadorRepository;

@Service
public class EquipeService {

	private EquipeRepository equipeRepository;
	private JogadorRepository jogadorRepository;
	
	@Autowired
	public EquipeService(EquipeRepository equipeRepository, JogadorRepository jogadorRepository){
		this.equipeRepository = equipeRepository;
		this.jogadorRepository=jogadorRepository;
	}
	
	public boolean criarEquipe(Equipe equipe){
		
		if(this.equipeRepository.findByClube(equipe.getClube())!=null)
			return false;
		
		this.equipeRepository.save(equipe);
		return true;
		
	}
	
	public boolean adicionarJogadorAEquipe(Long idEquipe, Long idJogador){
		try{
			Equipe equipe = this.equipeRepository.findOne(idEquipe);
			Jogador jogador = this.jogadorRepository.findOne(idJogador);
			equipe.getJogadores().add(jogador);
			this.equipeRepository.save(equipe);
			return true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
	}
	
	public boolean removerJogadorDaEquipe(Long idEquipe, Long idJogador){
		try{
			Equipe equipe = this.equipeRepository.findOne(idEquipe);
			Jogador jogador = this.jogadorRepository.findOne(idJogador);
			equipe.getJogadores().remove(jogador);
			this.equipeRepository.save(equipe);
			return true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
	}
}
