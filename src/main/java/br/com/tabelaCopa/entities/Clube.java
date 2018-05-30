package br.com.tabelaCopa.entities;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tabelaCopa.requestBodies.ClubeRequestBody;
import br.com.tabelaCopa.requestBodies.PaisRequestBody;

@Entity
@Table(name="clube")
public class Clube {
	
	@Id
	@Column(name="idClube")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="registro")
	private Long registro;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="data_fundacao")
	private Date dataFundacao;
	
	@OneToOne(mappedBy="clube")
	private Equipe equipe;
	
	@Column(name="endereco_logo")
	private String enderecoLogo;
	
	@Transient
	private File logo;
	
	@OneToMany(mappedBy="clube")
	@JsonIgnore
	private List<ClubeJogador>jogadores;
	
	@OneToMany
	@JoinColumn(name="edicao_id")
	private List<Edicao>titulos;
	
	@ManyToOne
	@JoinColumn(name="nacionalidade_id", referencedColumnName="id", nullable=true)
	private Pais nacionalidade;
	
	
	public Clube(){
		
	}
	
	public Clube(ClubeRequestBody requestBody){
		setId(requestBody.id);
		setNome(requestBody.nome);
		setRegistro(requestBody.registro);
		setDataFundacao(requestBody.dataFundacao);
		setLogo(requestBody.foto);
		SetNacionalidadePaisRequestBody(requestBody.nacionalidade);
	}
	
	public List<Edicao> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Edicao> titulos) {
		this.titulos = titulos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id!=null)
			this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null && !"".equals(nome))
			this.nome = nome;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<ClubeJogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<ClubeJogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		if(dataFundacao!=null)
			this.dataFundacao = dataFundacao;
	}

	public String getEnderecoLogo() {
		return enderecoLogo;
	}

	public void setEnderecoLogo(String enderecoLogo) {
		if(enderecoLogo!=null && !"".equals(enderecoLogo))
			this.enderecoLogo = enderecoLogo;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		if(logo!=null)
			this.logo = logo;
	}

	public Pais getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Pais nacionalidade) {
		if(nacionalidade!=null)
			this.nacionalidade = nacionalidade;
	}

	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
		if(registro!=null)
			this.registro = registro;
	}
	
	public void SetNacionalidadePaisRequestBody(PaisRequestBody pais){
		if(pais!=null)
			this.nacionalidade=new Pais(pais);
	}
}
