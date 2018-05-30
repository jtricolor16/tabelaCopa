package br.com.tabelaCopa.services;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tabelaCopa.entities.Jogador;
import br.com.tabelaCopa.entities.Pais;
import br.com.tabelaCopa.repositories.JogadorRepository;
import br.com.tabelaCopa.repositories.PaisRepository;
import br.com.tabelaCopa.validations.JogadorValidation;
import entitiesConfig.Image;

@Service
public class JogadorService {
	
	private JogadorRepository jogadorRepository;
	private PaisRepository paisRepository;
	
	@Autowired
	public JogadorService(JogadorRepository jogadorRepository, PaisRepository paisRepository){
		this.jogadorRepository=jogadorRepository;
		this.paisRepository=paisRepository;
	}
	
	public boolean salvar(ServletContext context, Jogador jogador){
		
		if(new JogadorValidation().validarJogador(this.jogadorRepository, jogador.getCpf(), jogador.getRg(), jogador.getId())==true){
			Pais pais=new Pais();
			if(jogador.getNacionalidade()!=null){
				pais = this.paisRepository.findByNome(jogador.getNacionalidade().getNome());
				jogador.setNacionalidade(pais);
			}
			Image image = new Image();
			if(jogador.getFoto()!=null){
				jogador.setEnderecoFoto(image.saveFoto(context, jogador.getFoto(), jogador.getCpf(), "jogadores"));
			}
			
			this.jogadorRepository.save(jogador);
			return true;
		}
		return false;
	}
	
	public boolean editar(ServletContext context, Jogador jogador){
		Jogador jogadorAntigo = jogadorRepository.findOne(jogador.getId());
		Pais pais = new Pais();
		if(new JogadorValidation().validarJogador(jogadorRepository, jogador.getCpf(), jogador.getRg(), jogador.getId())){
			if(jogador.getNacionalidade()!=null){
				pais = this.paisRepository.findByNome(jogador.getNacionalidade().getNome());
				jogador.setNacionalidade(pais);
			}
			Image image = new Image();
			if(jogador.getFoto()!=null){
				jogador.setEnderecoFoto(image.saveFoto(context, jogador.getFoto(), jogador.getCpf(), "jogadores"));
				if("erro".equals(jogador.getEnderecoFoto())){
					return false;
				}
				if(!jogador.getCpf().equals(jogadorAntigo.getCpf())){
					image.deleteFoto(context, jogadorAntigo.getEnderecoFoto(), "jogadores");
				}
			}else{
				jogador.setEnderecoFoto(null);
			}
			this.jogadorRepository.save(jogador);
			return true;
		}
		return false;
	}
	
	public boolean deletar(ServletContext context, Long id){
		try{
			Jogador jogador = this.jogadorRepository.findOne(id);
			new Image().deleteFoto(context, jogador.getEnderecoFoto(), "jogadores");
			this.jogadorRepository.delete(jogador);
			return true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
		
		
	}
	
	public Iterable<Jogador> listar(){
		return this.jogadorRepository.findAll();
	}
	
	public Iterable<Jogador>listarJogadorPorPais(Long id){
		Pais pais = this.paisRepository.findOne(id);
		return this.jogadorRepository.findByNacionalidade(pais);
	}
}
