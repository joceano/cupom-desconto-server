package br.com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Avaliacao;
import br.com.api.model.Cupom;
import br.com.api.service.AvaliacaoService;

@RestController
@RequestMapping("avaliacao")
public class AvaliacaoController {
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@RequestMapping(value = "nota/", method = RequestMethod.POST)
	public Avaliacao findByCupom(@RequestBody Cupom cupom){
		return avaliacaoService.findByCupom(cupom);
	}
		
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Avaliacao save(@RequestBody Avaliacao avaliacao){
		return avaliacaoService.save(avaliacao);
	}	

}
