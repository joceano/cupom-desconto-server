package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.Avaliacao;
import br.com.api.model.Cupom;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	
	Avaliacao findByCupom(Cupom cupom);

}
