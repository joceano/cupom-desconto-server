package br.com.api.service;

import java.util.List;

import br.com.api.model.Estado;

public interface EstadoService {
	
	Estado findOne(Long codigo);
	
	List<Estado> findAll();
	
	void delete(Long codigo);
	
	Estado save(Estado estado);
	
	void edit(Estado estado);

}
