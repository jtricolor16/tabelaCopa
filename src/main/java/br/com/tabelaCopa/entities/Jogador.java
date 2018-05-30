package br.com.tabelaCopa.entities;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tabelaCopa.requestBodies.JogadorRequestBody;


@Entity
@Table(name="jogador")
public class Jogador extends Pessoa{
	
	@Id
	@Column(name="idJogador")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="apelido", nullable=true)
	private String apelido;
	
	@OneToMany(mappedBy="jogador")
	@JsonIgnore
	private List<ClubeJogador>clubes;
	
	public Jogador(){
		
	}
	
	public Jogador(Long id, String nome, String apelido, String cpf, String rg, Pais nacionalidade, File foto, Date data){
		super(nome, cpf, rg, foto, data);
		setNacionalidade(nacionalidade);
		setId(id);
		setApelido(apelido);
	}
	
	public Jogador(JogadorRequestBody jogadorRequestBody){
		super(jogadorRequestBody.nome, jogadorRequestBody.cpf, jogadorRequestBody.rg, jogadorRequestBody.foto, jogadorRequestBody.dataNascimento);
		setId(jogadorRequestBody.id);
		SetNacionalidadePaisRequestBody(jogadorRequestBody.nacionalidade);
		setApelido(jogadorRequestBody.apelido);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id!=null)
			this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		if(apelido!=null && !"".equals(apelido))
			this.apelido = apelido;
	}

	public List<ClubeJogador> getClubes() {
		return clubes;
	}

	public void setClubes(List<ClubeJogador> clubes) {
		this.clubes = clubes;
	}
	
	
	
}
