package br.com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Estado;
import br.com.api.repository.EstadoRepository;
import br.com.api.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public Estado findOne(Long codigo) {		
		return estadoRepository.findOne(codigo);
	}

	@Override
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@Override
	public void delete(Long codigo) {
		estadoRepository.delete(codigo);
	}

	@Override
	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Override
	public void edit(Estado estado) {
		estadoRepository.save(estado);
	}

}
