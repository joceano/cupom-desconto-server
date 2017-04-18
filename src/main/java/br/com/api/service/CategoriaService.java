package br.com.api.service;

import java.util.List;

import br.com.api.model.Categoria;

public interface CategoriaService {
	
	Categoria findOne(Long codigo);
	
	List<Categoria> findAll();
	
	List<Categoria> findAutocomplete(String descricao);
	
	void delete(Long codigo);
	
	Categoria save(Categoria categoria);
	
	void edit(Categoria categoria);

}
