package br.com.tabelaCopa.requestBodies;

import java.io.File;
import java.sql.Date;

public class ClubeRequestBody {

	public Long id;
	
	public Long registro;
	
	public String nome;
	
	public Date dataFundacao;
	
	public PaisRequestBody nacionalidade;
	
	public File foto;
	
}
