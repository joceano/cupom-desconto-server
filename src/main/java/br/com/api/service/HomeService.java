package br.com.api.service;

import java.util.List;

import br.com.api.model.Anuncio;

public interface HomeService {
	
	List<Anuncio> findAll();

}
