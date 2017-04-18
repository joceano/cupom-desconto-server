package br.com.api.service;

import java.util.List;

import br.com.api.model.Anuncio;

public interface AnuncioService {
	
	Anuncio findOne(Long codigo);
	
	List<Anuncio> findAll();
	
	void delete(Long codigo);
	
	Anuncio save(Anuncio anuncio);
	
	void edit(Anuncio anuncio);

}
