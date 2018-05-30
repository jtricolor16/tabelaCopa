package br.com.tabelaCopa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tabelaCopa.entities.Clube;
import br.com.tabelaCopa.entities.ClubeJogador;
import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.repositories.ClubeJogadorRepository;
import br.com.tabelaCopa.repositories.ClubeRepository;
import br.com.tabelaCopa.repositories.JogadorRepository;

@Service
public class ClubeJogadorService {
	
	private ClubeRepository clubeRepository;
	private JogadorRepository jogadorRepository;
	private ClubeJogadorRepository clubeJogadorRepository;
	
	@Autowired
	public ClubeJogadorService(ClubeRepository clubeRepository, JogadorRepository jogadorRepository, ClubeJogadorRepository clubeJogadorRepository){
		this.clubeRepository=clubeRepository;
		this.jogadorRepository=jogadorRepository;
		this.clubeJogadorRepository=clubeJogadorRepository;
	}
	
	public boolean adicionarClubeAoJogador(ClubeJogador clubeJogador){
		Jogador jogador = this.jogadorRepository.findOne(clubeJogador.getJogador().getId());
		Clube clube = this.clubeRepository.findOne(clubeJogador.getClube().getId());
		if(jogador!=null && clube!=null){
			clubeJogador.setJogador(jogador);
			clubeJogador.setClube(clube);
			this.clubeJogadorRepository.save(clubeJogador);
			return true;
		}
		return false;
	}
	
	public List<Jogador>carregarJogadoresPorClube(Long idClube){
		Clube clube = this.clubeRepository.findOne(idClube);
		Iterable<ClubeJogador>clubeJogadores = this.clubeJogadorRepository.findByClube(clube);
		List<Jogador>jogadores = new ArrayList<Jogador>();
		for(ClubeJogador clubeJogador : clubeJogadores){
			jogadores.add(clubeJogador.getJogador());
		}
		return jogadores;
	}
	
	public List<Clube>carregarClubesPorJogador(Long idJogador){
		Jogador jogador = this.jogadorRepository.findOne(idJogador);
		Iterable<ClubeJogador> clubeJogadores = this.clubeJogadorRepository.findByJogador(jogador);
		List<Clube>clubes = new ArrayList<Clube>();
		
		for(ClubeJogador clubeJogador : clubeJogadores){
			clubes.add(clubeJogador.getClube());
		}
		
		return clubes;
	}
	
}
