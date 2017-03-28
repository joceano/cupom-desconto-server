package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
