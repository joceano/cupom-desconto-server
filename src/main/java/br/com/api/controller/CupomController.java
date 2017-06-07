package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Anuncio;
import br.com.api.model.Cupom;
import br.com.api.service.CupomService;

@RestController
@RequestMapping("cupom")
public class CupomController {
	
	@Autowired
	private CupomService cupomService;
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Cupom findOne(@PathVariable Long codigo){
		return cupomService.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Cupom> findAll(){
		return cupomService.findAll();
	}
	
	@RequestMapping(value = "anuncios/", method = RequestMethod.POST)
	public List<Cupom> findByAnuncio(@RequestBody Anuncio anuncio){
		return cupomService.findByAnuncio(anuncio);
	}
		
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long codigo){
		cupomService.delete(codigo);
	}
		
	@RequestMapping(value = "/", method = RequestMethod.POST)	
	public Cupom save(@RequestBody Cupom cupom){
		return cupomService.save(cupom);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Cupom cupom){
		cupomService.save(cupom);
	}
}
