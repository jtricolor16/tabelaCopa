package br.com.tabelaCopa.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.tabelaCopa.entities.Clube;
import br.com.tabelaCopa.entities.Pais;

public interface ClubeRepository extends PagingAndSortingRepository<Clube, Long>{
	
	public Clube findByRegistro(@Param("registro") Long registro);
	
	public List<Clube>findByNome(@Param("nome") String nome);
	
	public List<Clube>findByNacionalidade(@Param("nacionalidade") Pais nacionalidade);
	
}
