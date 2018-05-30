package br.com.tabelaCopa.requestBodies;

import java.io.File;
import java.sql.Date;

public class PessoaRequestBody {
	
	public String nome;
	
	public String rg;
	
	public String cpf;
	
	public PaisRequestBody nacionalidade;
	
	public File foto;
	
	public Date dataNascimento;
	
}
