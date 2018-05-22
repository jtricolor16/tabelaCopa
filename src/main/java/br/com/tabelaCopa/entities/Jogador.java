package br.com.tabelaCopa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.tabelaCopa.requestBodies.JogadorRequestBody;


@Entity
@Table(name="jogador")
public class Jogador extends Pessoa{
	
	@Id
	@Column(name="idJogador")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Jogador(){
		
	}
	
	public Jogador(String nome, String cpf, String rg, Pais nacionalidade){
		super(nome, cpf, rg, nacionalidade);
	}
	
	public Jogador(JogadorRequestBody jogadorRequestBody){
		super(jogadorRequestBody.nome, jogadorRequestBody.cpf, jogadorRequestBody.rg, new Pais(jogadorRequestBody.nacionalidade));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
