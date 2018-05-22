package br.com.tabelaCopa.validations;

import br.com.tabelaCopa.repositories.JogadorRepository;

public class JogadorValidation {
	
	public boolean validarJogador(JogadorRepository repository, String cpf, String rg){
		if(this.validarCpf(repository, cpf)==true && this.validarRg(repository, rg)==true){
			return true;
		}
		return false;
	}
	
	private boolean validarCpf(JogadorRepository repository, String cpf){
		
		if(repository.findByCpf(cpf)==null)
			return true;
		
		return false;
	}
	
	private boolean validarRg(JogadorRepository repository, String rg){
		if(repository.findByRg(rg)==null)
			return true;
		
		return false;
	}

	
}
