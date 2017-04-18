package br.com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Pais;
import br.com.api.repository.PaisRepository;
import br.com.api.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	public Pais findOne(Long codigo) {
		return paisRepository.findOne(codigo);
	}

	@Override
	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	@Override
	public void delete(Long codigo) {
		paisRepository.delete(codigo);		
	}

	@Override
	public Pais save(Pais pais) {
		return paisRepository.save(pais);
	}

	@Override
	public void edit(Pais pais) {
		paisRepository.save(pais);
	}

}
