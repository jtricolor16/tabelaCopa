package br.com.tabelaCopa.requestBodies;

import java.math.BigDecimal;
import java.sql.Date;

public class ClubeJogadorRequestBody {
	
	public JogadorRequestBody jogador;
	
	public ClubeRequestBody clube;
	
	public Date dataChegada;
	
	public Date dataSaida;
	
	public BigDecimal valorChegada;
	
	public BigDecimal valorSaida;
	
}
