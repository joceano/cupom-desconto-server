package br.com.api.service;

import java.util.List;

import br.com.api.model.Pais;

public interface PaisService {
	
	Pais findOne(Long codigo);
	
	List<Pais> findAll();
	
	void delete(Long codigo);
	
	Pais save(Pais pais);
	
	void edit(Pais pais);
	
}
