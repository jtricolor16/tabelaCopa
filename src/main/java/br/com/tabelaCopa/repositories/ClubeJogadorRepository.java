package br.com.tabelaCopa.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.tabelaCopa.entities.Clube;
import br.com.tabelaCopa.entities.ClubeJogador;
import br.com.tabelaCopa.entities.Jogador;

public interface ClubeJogadorRepository extends PagingAndSortingRepository<ClubeJogador, Long> {
	
	public List<ClubeJogador>findByJogador(@Param("jogador") Jogador jogador);
	
	public List<ClubeJogador>findByClube(@Param("clube") Clube clube);
}
