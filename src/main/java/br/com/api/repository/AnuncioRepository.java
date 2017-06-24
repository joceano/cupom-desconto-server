package br.com.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.model.Anuncio;
import br.com.api.model.User;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{
	
	List<Anuncio> findByUsuario(User usuario);
	
	@Query("select a from Anuncio a where a.aprovado = ?1 and a.ativo = ?2 and "+
		   "?3 between a.dataInicial and a.dataFinal")
	List<Anuncio> findByAnuncioValido(Boolean aprovado, Boolean ativo, Date dataIni);

}
