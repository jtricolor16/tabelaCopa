package br.com.tabelaCopa.entities;

import java.io.File;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import br.com.tabelaCopa.requestBodies.PaisRequestBody;

@MappedSuperclass
public abstract class Pessoa {
	
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="pais_id", referencedColumnName="id", nullable=true)
	private Pais nacionalidade;
	
	@Column(name="cpf", nullable=false)
	private String cpf;
	
	@Column(name="rg", nullable=true)
	private String rg;
	
	@Column(name="foto", nullable=true)
	private String enderecoFoto;
	
	@Column(name="data_nascimento")
	private Date dataNascimento;
	
	@Transient
	private File foto;
	
	public Pessoa(){
		
	}
	
	
	public Pessoa(String nome, String cpf, String rg, File foto, Date data){
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setFoto(foto);
		setDataNascimento(data);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null && !"".equals(nome))
			this.nome = nome;
	}

	public Pais getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Pais nacionalidade) {
		if(nacionalidade!=null && !"".equals(nacionalidade))
			this.nacionalidade = nacionalidade;
	}
	
	public void SetNacionalidadePaisRequestBody(PaisRequestBody pais){
		if(pais!=null)
			this.nacionalidade=new Pais(pais);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf!=null && !"".equals(cpf))
			this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		if(rg!=null && !"".equals(rg))
			this.rg = rg;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getEnderecoFoto() {
		return enderecoFoto;
	}

	public void setEnderecoFoto(String enderecoFoto) {
		if(enderecoFoto!=null && !"".equals(enderecoFoto))
			this.enderecoFoto = enderecoFoto;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		if(dataNascimento!=null)
			this.dataNascimento = dataNascimento;
	}

	
}
