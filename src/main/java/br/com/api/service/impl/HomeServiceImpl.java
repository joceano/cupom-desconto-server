package br.com.api.service.impl;

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
		return anuncioRepository.findAll();
	}

}
