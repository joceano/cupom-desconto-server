package br.com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Cidade;
import br.com.api.repository.CidadeRepository;
import br.com.api.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public Cidade findOne(Long codigo) {
		return cidadeRepository.findOne(codigo);
	}

	@Override
	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	@Override
	public void delete(Long codigo) {
		cidadeRepository.delete(codigo);
	}

	@Override
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@Override
	public void edit(Cidade cidade) {
		cidadeRepository.save(cidade);
	}
}
