package br.com.api.service;

import java.util.List;

import br.com.api.model.Cidade;

public interface CidadeService {
	
	Cidade findOne(Long codigo);
	
	List<Cidade> findAll();
	
	void delete(Long codigo);
	
	Cidade save(Cidade cidade);
	
	void edit(Cidade cidade);

}
