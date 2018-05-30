package br.com.tabelaCopa.validations;

import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.repositories.JogadorRepository;

public class JogadorValidation {
	
	public boolean validarJogador(JogadorRepository repository, String cpf, String rg, Long id){
		Jogador jogadorRg=null;
		
		if(rg!=null && !"".equals(rg))
			jogadorRg = repository.findByRg(rg);
		
		Jogador jogadorCpf = repository.findByCpf(cpf);
		
		if(this.validarString(repository, jogadorCpf, id)==true && this.validarString(repository, jogadorRg, id)==true){
			return true;
		}
		return false;
	}
	
	private boolean validarString(JogadorRepository repository, Jogador jogador, Long id){
		if(jogador==null)
			return true;
		
		if(jogador!=null && id!=null){
			if(jogador.getId()==id){
				return true;
			}
			return false;
		}
		return false;
	}

	
}
