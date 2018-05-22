package br.com.tabelaCopa.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.tabelaCopa.entities.Pais;

public interface PaisRepository extends PagingAndSortingRepository<Pais, Long> {
	
	Pais findById(@Param("id") Long id);
	Pais findByNome(@Param("nome") String nome);
	
}
