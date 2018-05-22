package br.com.tabelaCopa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tabelaCopa.entities.Pais;
import br.com.tabelaCopa.repositories.PaisRepository;

@Service
public class PaisService {
	private PaisRepository paisRepository;
	
	@Autowired
	public PaisService(PaisRepository paisRepository){
		this.paisRepository=paisRepository;
	}
	
	public boolean salvar(Pais pais){
		Pais paisNovo = this.paisRepository.findByNome(pais.getNome());
		
		if(paisNovo==null){
			paisRepository.save(pais);
			return true;
		}
		return false;
	}
	
	public boolean deletar(Long id){
		
		Pais pais = this.paisRepository.findById(id);
		
		if(pais!=null){
			paisRepository.delete(pais);
			return true;
		}
		return false;
	}
	
	public boolean editar(Long id, String nome){
		Pais pais = paisRepository.findById(id);
		if(pais!=null){
			pais.setNome(nome);
			paisRepository.save(pais);
			return true;
		}
		
		return false;
		
	}
	
	public List<Pais> listar(){
		Iterable<Pais> iterablePaises = paisRepository.findAll();
		List<Pais>paises = new ArrayList<Pais>();
		for (Pais pais : iterablePaises){
			paises.add(pais);
		}
		return paises;
	}
	
	public Pais findPaisByName(String nome){
		return paisRepository.findByNome(nome);
	}
}
