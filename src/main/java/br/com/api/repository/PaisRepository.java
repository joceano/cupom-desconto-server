package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{

}
