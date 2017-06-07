package br.com.api.service;

import java.util.List;

import br.com.api.model.Anuncio;
import br.com.api.model.Cupom;

public interface CupomService {
	
	Cupom findOne(Long codigo);
	
	List<Cupom> findAll();
	
	List<Cupom> findByAnuncio(Anuncio anuncio);
	
	void delete(Long codigo);
	
	Cupom save(Cupom cupom);
	
	void edit(Cupom cupom);

}
