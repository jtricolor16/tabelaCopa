package br.com.tabelaCopa.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.tabelaCopa.entities.Clube;
import br.com.tabelaCopa.entities.Equipe;

public interface EquipeRepository extends PagingAndSortingRepository<Equipe, Long> {
	
	public Equipe findByClube(@Param("clube") Clube clube);
	
}
