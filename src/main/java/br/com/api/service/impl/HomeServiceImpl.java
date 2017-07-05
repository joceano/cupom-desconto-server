package br.com.api.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Anuncio;
import br.com.api.repository.AnuncioRepository;
import br.com.api.service.CupomService;
import br.com.api.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Autowired
	private CupomService cupomService;

	@Override
	public List<Anuncio> findAll() {						
		return retornarAnuncios();		
	}
	
	private List<Anuncio> retornarAnuncios() {
		Date data = zerarHora(new Date());
		List<Anuncio> anuncios = anuncioRepository.findByAnuncioValido(true, true, data);
		
		for (Anuncio anuncio : anuncios) {
			Integer qtdeCupons = cupomService.findByAnuncio(anuncio).size();
			Integer qtdeRestante = (int) (anuncio.getQuantidade() - qtdeCupons);
			anuncio.setRestante(qtdeRestante);
		}
		return anuncios;
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
