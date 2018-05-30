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


@Entity
@Table(name="edicao")
public class Edicao {
	@Id
	@Column(name="id_edicao")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="qtdclubes")
	private Integer qtdClubes;
	
	@OneToOne
	@JoinColumn(name="temporada_id")
	private Temporada temporada;
	
	@OneToOne
	@JoinColumn(name="campeonato_id")
	private Campeonato campeonato;
	
	@OneToMany
	@JoinColumn(name="fase_id")
	private List<Fase>fases;

	public List<Fase> getFases() {
		return fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtdClubes() {
		return qtdClubes;
	}

	public void setQtdClubes(Integer qtdClubes) {
		this.qtdClubes = qtdClubes;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
}
