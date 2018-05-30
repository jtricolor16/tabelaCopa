package br.com.tabelaCopa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tabelaCopa.requestBodies.ClubeJogadorRequestBody;

@Entity
@Table(name="clubejogador")
public class ClubeJogador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idClubeJogador")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="clube_id")
	private Clube clube;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="jogador_id")
	private Jogador jogador;
	
	@Column(name="dataChegada")
	private Date dataChegada;
	
	@Column(name="dataSaida")
	private Date dataSaida;
	
	@Column(name="valorChegada")
	private BigDecimal valorChegada;
	
	@Column(name="valorSaida")
	private BigDecimal valorSaida;
	
	public ClubeJogador(){
		
	}
	
	public ClubeJogador(ClubeJogadorRequestBody requestBody){
		setClube(new Clube(requestBody.clube));
		setJogador(new Jogador(requestBody.jogador));
		setDataChegada(requestBody.dataChegada);
		setDataSaida(requestBody.dataSaida);
		setValorChegada(requestBody.valorChegada);
		setValorSaida(requestBody.valorSaida);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		if(clube!=null)
			this.clube = clube;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		if(jogador!=null)
			this.jogador = jogador;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		if(dataChegada != null)
			this.dataChegada = dataChegada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		if(dataSaida!=null)
			this.dataSaida = dataSaida;
	}

	public BigDecimal getValorChegada() {
		return valorChegada;
	}

	public void setValorChegada(BigDecimal valorChegada) {
		if(valorChegada!=null)
			this.valorChegada = valorChegada;
	}

	public BigDecimal getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(BigDecimal valorSaida) {
		if(valorSaida!=null)
			this.valorSaida = valorSaida;
	}
}
