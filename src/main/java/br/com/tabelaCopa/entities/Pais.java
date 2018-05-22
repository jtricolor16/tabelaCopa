package br.com.tabelaCopa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.tabelaCopa.requestBodies.PaisRequestBody;


@Entity
@Table(name="pais")
public class Pais {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	
	public Pais(){
		
	}
	
	public Pais(String nome){
		this.nome=nome;
	}
	
	public Pais(PaisRequestBody requestBody){
		this.nome=requestBody.nome;
	}
	
	//=====================Métodos=================//
	
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public Long getId(){
		return this.id;
	}
}
