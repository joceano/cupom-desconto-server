package br.com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Categoria;
import br.com.api.repository.CategoriaRepository;
import br.com.api.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria findOne(Long codigo) {
		return categoriaRepository.findOne(codigo);
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public void delete(Long codigo) {
		categoriaRepository.delete(codigo);
	}

	@Override
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void edit(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> findAutocomplete(String descricao) {		
		if (descricao.isEmpty()) {
			return categoriaRepository.findAll();
		} else {
			return categoriaRepository.findByDescricaoContaining(descricao);
		}		
	}
}
