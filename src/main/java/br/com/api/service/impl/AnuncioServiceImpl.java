package br.com.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Anuncio;
import br.com.api.model.User;
import br.com.api.repository.AnuncioRepository;
import br.com.api.service.AnuncioService;
import br.com.api.service.SecurityService;

@Service
public class AnuncioServiceImpl implements AnuncioService{
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Autowired
	private SecurityService securityService;

	@Override
	public Anuncio findOne(Long codigo) {
		return anuncioRepository.findOne(codigo);
	}

	@Override
	public List<Anuncio> findAll() {
		return retornarAnuncios();
	}	

	@Override
	public void delete(Long codigo) {
		anuncioRepository.delete(codigo);
	}

	@Override
	public Anuncio save(Anuncio anuncio) {				
		if (anuncio.getDataCriacao() == null) {
			anuncio.setDataCriacao(new Date());
		}		
		if (anuncio.getUsuario() == null) {
			anuncio.setUsuario(securityService.userLogged());
		}			
		return anuncioRepository.save(anuncio);
	}

	@Override
	public void edit(Anuncio anuncio) {
		anuncioRepository.save(anuncio);
	}
	
	private List<Anuncio> retornarAnuncios() {
        User userLogado =  securityService.userLogged();						
		if (userLogado != null && userLogado.getRoles().equals(User.ROLE_USER)) {
			return anuncioRepository.findByUsuario(userLogado);
		} else {
			return anuncioRepository.findAll();
		}
	}
}
