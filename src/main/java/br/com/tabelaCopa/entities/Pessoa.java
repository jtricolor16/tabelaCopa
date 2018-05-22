package br.com.tabelaCopa.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {
	
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="pais_id", referencedColumnName="id", nullable=true)
	private Pais nacionalidade;
	
	@Column(name="cpf", nullable=true)
	private String cpf;
	
	@Column(name="rg", nullable=true)
	private String rg;
	
	public Pessoa(){
		
	}
	
	public Pessoa(String nome, String cpf, String rg, Pais nacionalidade){
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setNacionalidade(nacionalidade);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null)
			this.nome = nome;
	}

	public Pais getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Pais nacionalidade) {
		if(nacionalidade!=null)
			this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf!=null)
			this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		if(rg!=null)
			this.rg = rg;
	}
}
