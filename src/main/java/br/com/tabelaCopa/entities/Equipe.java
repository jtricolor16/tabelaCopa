package br.com.tabelaCopa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.tabelaCopa.requestBodies.EquipeRequestBody;


@Entity
@Table(name="equipe")
public class Equipe {
	@Id
	@Column(name="idEquipe")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@JoinColumn(name="equipe_id")
	private List<Jogador>jogadores;
	
	@OneToOne
	@JoinColumn(name="clube_id")
	private Clube clube;
	
	public Equipe(){
		
	}
	
	public Equipe(EquipeRequestBody equipeRequestBody){
		setId(equipeRequestBody.id);
		setClube(new Clube(equipeRequestBody.clube));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id!=null)
			this.id = id;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		if(clube!=null)
			this.clube = clube;
	}
	
}
