package br.com.tabelaCopa.services;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tabelaCopa.entities.Clube;
import br.com.tabelaCopa.repositories.ClubeRepository;
import br.com.tabelaCopa.repositories.PaisRepository;
import entitiesConfig.Image;

@Service
public class ClubeService {
	
	private PaisRepository paisRepository;
	private ClubeRepository clubeRepository;
	private Image image;
	
	@Autowired
	public ClubeService(ClubeRepository clubeRepository, PaisRepository paisRepository){
		this.clubeRepository=clubeRepository;
		this.paisRepository=paisRepository;
		this.image=new Image();
	}
	
	public boolean save(ServletContext context, Clube clube){
		if(this.clubeRepository.findByRegistro(clube.getRegistro())!=null)
			return false;
		if(clube.getNacionalidade()!=null){
			clube.setNacionalidade(this.paisRepository.findByNome(clube.getNacionalidade().getNome()));
		}
		if(clube.getLogo()!=null){
			clube.setEnderecoLogo(image.saveFoto(context, clube.getLogo(), clube.getRegistro().toString(), "clubes"));
			if("erro".equals(clube.getEnderecoLogo())){
				return false;
			}
		}
		this.clubeRepository.save(clube);
		return true;
	}
	
	public boolean editar(ServletContext context, Clube clube){
		Clube clubeAntigo = this.clubeRepository.findOne(clube.getId());
		if(!clubeAntigo.getRegistro().equals(clube.getRegistro())){
			if(this.clubeRepository.findByRegistro(clube.getRegistro())!=null){
				return false;
			}
		}
		if(clube.getNacionalidade()!=null){
			clube.setNacionalidade(this.paisRepository.findByNome(clube.getNacionalidade().getNome()));
		}
		if(clube.getLogo()!=null){
			clube.setEnderecoLogo(image.saveFoto(context, clube.getLogo(), clube.getRegistro().toString(), "clubes"));
			if("erro".equals(clube.getEnderecoLogo())){
				return false;
			}
		}
		this.clubeRepository.save(clube);
		return true;
	}
	
	public boolean delete(Long id){
		this.clubeRepository.delete(id);
		return true;
	}
	
	public Iterable<Clube>listar(){
		return this.clubeRepository.findAll();
	}
	
	public Clube buscaClubePorRegistro(Long registro){
		return this.clubeRepository.findByRegistro(registro);
	}
	
	public Clube buscaClubePorId(Long id){
		return this.clubeRepository.findOne(id);
	}
}
