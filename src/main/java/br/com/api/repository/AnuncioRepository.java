package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Anuncio;
import br.com.api.model.User;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{
	
	List<Anuncio> findByUsuario(User usuario);

}
