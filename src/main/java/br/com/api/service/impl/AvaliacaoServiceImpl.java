package br.com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Avaliacao;
import br.com.api.model.Cupom;
import br.com.api.repository.AvaliacaoRepository;
import br.com.api.service.AvaliacaoService;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService{

	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	@Override
	public Avaliacao findOne(Long codigo) {		
		return avaliacaoRepository.findOne(codigo);
	}

	@Override
	public List<Avaliacao> findAll() {		
		return avaliacaoRepository.findAll();
	}

	@Override
	public Avaliacao findByCupom(Cupom cupom) {
		return avaliacaoRepository.findByCupom(cupom);
	}

	@Override
	public Avaliacao save(Avaliacao avaliacao) {
		if (avaliacao.getId() == null) {
			return avaliacaoRepository.save(avaliacao);
		} else {
			return avaliacao;
		}		
	}
}
