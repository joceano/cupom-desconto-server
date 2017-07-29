package br.com.api.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Anuncio;
import br.com.api.model.Cupom;
import br.com.api.model.Usuario;
import br.com.api.repository.CupomRepository;
import br.com.api.service.AnuncioService;
import br.com.api.service.CupomService;
import br.com.api.service.SecurityService;

@Service
public class CupomServiceImpl implements CupomService {

	@Autowired
	private CupomRepository cupomRepository;
	
	@Autowired
	private AnuncioService anuncioService;
	
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
		return cupomRepository.save(cupom);
	}
	
	@Override
	public void edit(Cupom cupom) {
		cupomRepository.save(cupom);
	}

	@Override
	public String pegarCupom(Cupom cupom) {
		if (!isAtivo(cupom)) {
			return "Ops, esse cupom não está mais ativo!";
		} else if (!isAprovado(cupom)) {
			return "Ops, esse cupom não está aprovado!";
		} else if (isExpirado(cupom)) {
			return "Ops, esse cupom já expirou!";
		} else if (isQtdeExpirada(cupom)) {
			return "Ops, este anúncio não possui mais cupons disponíveis!";
		} else if (isQtdeUserExpirada(cupom)) { 
			return "Ops, você já adquiriu o seu cupom deste anúncio!";
		} else {	
			if (cupom.getId() == null) {
				cupom.setData(new Date());
				cupom.setBaixado(false);
			}
			try {
				cupomRepository.save(cupom);
				validarCotaCupomExcedido(cupom);
				return "Parabéns, seu desconto está garantido!";
			} catch (Exception e) {
				return "Ops, não foi possível adquirir esse cupom!";
			}
		}
	}	

	private void validarCotaCupomExcedido(Cupom cupom) {
		List<Cupom> cupons = cupomRepository.findByAnuncio(cupom.getAnuncio());
		Boolean bUltimoCupom  = (cupons.size() >= cupom.getAnuncio().getQuantidade());
		if (bUltimoCupom) {
			Anuncio anuncio = anuncioService.findOne(cupom.getAnuncio().getId());
			anuncio.setAtivo(false);
			anuncioService.save(anuncio);
		}		
	}

	private boolean isQtdeUserExpirada(Cupom cupom) {
		List<Cupom> cupons = cupomRepository.findByAnuncioAndUsuario(
				cupom.getAnuncio(), cupom.getUsuario());
		return cupons.size() >= cupom.getAnuncio().getQuantidadeCli();
	}

	private boolean isQtdeExpirada(Cupom cupom) {		
		List<Cupom> cupons = cupomRepository.findByAnuncio(cupom.getAnuncio());
		return (cupons.size() >= cupom.getAnuncio().getQuantidade());
	}	
	
	private boolean isExpirado(Cupom cupom) {
		Date dataAtual   = zerarHora(new Date());
		Date dataInicial = zerarHora(cupom.getAnuncio().getDataInicial());
		Date dataFinal   = zerarHora(cupom.getAnuncio().getDataFinal());
		return (dataAtual.compareTo(dataInicial) < 0 || dataAtual.compareTo(dataFinal) > 0);
	}
	
	private boolean isAprovado(Cupom cupom) {
		return cupom.getAnuncio().getAprovado();
	}
	
	private boolean isAtivo(Cupom cupom) {		
		return cupom.getAnuncio().getAtivo();
	}
	
	private List<Cupom> retornarCupons() {
        Usuario userLogado =  securityService.userLogged();						
		if (userLogado != null && userLogado.getRoles().equals(Usuario.ROLE_USER)) {
			return cupomRepository.findByUsuario(userLogado);
		} else {
			return cupomRepository.findAll();
		}
	}
	
	private Date zerarHora(Date data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
			return format.parse(format.format(data));
		} catch (ParseException e) {
			return null;
		}
    }
}
