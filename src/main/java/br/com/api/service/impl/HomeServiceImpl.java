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
import br.com.api.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private AnuncioRepository anuncioRepository;

	@Override
	public List<Anuncio> findAll() {				
		Date data = zerarHora(new Date());				 	
		return anuncioRepository.findByAnuncioValido(true, true, data);
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
