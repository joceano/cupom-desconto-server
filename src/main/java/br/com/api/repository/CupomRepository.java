package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Anuncio;
import br.com.api.model.Cupom;
import br.com.api.model.Usuario;

public interface CupomRepository extends JpaRepository<Cupom, Long>{
	
	List<Cupom> findByUsuario(Usuario usuario);
	
	List<Cupom> findByAnuncio(Anuncio anuncio);
	
	List<Cupom> findByAnuncioAndUsuario(Anuncio anuncio, Usuario usuario);

}
