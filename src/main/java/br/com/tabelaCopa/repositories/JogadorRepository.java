package br.com.tabelaCopa.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.entities.Pais;

public interface JogadorRepository extends PagingAndSortingRepository<Jogador, Long>{
	
	List<Jogador>findByNome(@Param("nome") String nome);
	Jogador findByCpf(@Param("cpf") String cpf);
	Jogador findByRg(@Param("rg") String rg);
	List<Jogador>findByNacionalidade(@Param("nacionalidade") Pais nacionalidade);
}
