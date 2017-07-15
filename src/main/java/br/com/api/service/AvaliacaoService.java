package br.com.api.service;

import java.util.List;

import br.com.api.model.Avaliacao;
import br.com.api.model.Cupom;

public interface AvaliacaoService {
	
	Avaliacao findOne(Long codigo);
	
	List<Avaliacao> findAll();
	
	Avaliacao findByCupom(Cupom cupom);
	
	Avaliacao save(Avaliacao avaliacao);

}
