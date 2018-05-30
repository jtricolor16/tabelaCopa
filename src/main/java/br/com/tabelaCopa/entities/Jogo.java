package br.com.tabelaCopa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jogo")
public class Jogo {
	
	@Id
	@Column(name="id_jogo")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="clube_a_id")
	private Clube clubeA;
	
	@OneToOne
	@JoinColumn(name="clube_b_id")
	private Clube clubeB;
	
	@OneToMany(mappedBy="jogo")
	private List<Gol> golsEquipeA;
	
	@OneToMany(mappedBy="jogo")
	private List<Gol> golsEquipeB;
	
	@OneToOne
	@JoinColumn(name="fase_id")
	private Fase fase;
	
	@OneToOne
	@JoinColumn(name="edicao_id")
	private Edicao edicao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clube getClubeA() {
		return clubeA;
	}

	public void setClubeA(Clube clubeA) {
		this.clubeA = clubeA;
	}

	public Clube getClubeB() {
		return clubeB;
	}

	public void setClubeB(Clube clubeB) {
		this.clubeB = clubeB;
	}

	public List<Gol> getGolsEquipeA() {
		return golsEquipeA;
	}

	public void setGolsEquipeA(List<Gol> golsEquipeA) {
		this.golsEquipeA = golsEquipeA;
	}

	public List<Gol> getGolsEquipeB() {
		return golsEquipeB;
	}

	public void setGolsEquipeB(List<Gol> golsEquipeB) {
		this.golsEquipeB = golsEquipeB;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Edicao getEdicao() {
		return edicao;
	}

	public void setEdicao(Edicao edicao) {
		this.edicao = edicao;
	}
}
