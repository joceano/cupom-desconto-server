package br.com.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Anuncio;
import br.com.api.model.Cupom;
import br.com.api.model.User;
import br.com.api.repository.CupomRepository;
import br.com.api.service.CupomService;
import br.com.api.service.SecurityService;

@Service
public class CupomServiceImpl implements CupomService {

	@Autowired
	private CupomRepository cupomRepository;
	
	@Autowired
	private SecurityService securityService;
	
	@Override
	public Cupom findOne(Long codigo) {
		return cupomRepository.findOne(codigo);
	}

	@Override
	public List<Cupom> findAll() {
		return retornarCupons();
	}
	
	@Override
	public List<Cupom> findByAnuncio(Anuncio anuncio) {
		return cupomRepository.findByAnuncio(anuncio);
	}

	@Override
	public void delete(Long codigo) { 
		cupomRepository.delete(codigo);
	}

	@Override
	public Cupom save(Cupom cupom) {
		if (cupom.getId() == null){
			cupom.setData(new Date());
			cupom.setBaixado(false);
		}
		return cupomRepository.save(cupom);
	}

	@Override
	public void edit(Cupom cupom) {
		cupomRepository.save(cupom);
	}
	
	private List<Cupom> retornarCupons() {
        User userLogado =  securityService.userLogged();						
		if (userLogado != null && userLogado.getRoles().equals(User.ROLE_USER)) {
			return cupomRepository.findByUsuario(userLogado);
		} else {
			return cupomRepository.findAll();
		}
	}
}
