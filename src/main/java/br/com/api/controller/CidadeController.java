package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Cidade;
import br.com.api.service.CidadeService;

@RestController
@RequestMapping("cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Cidade findOne(@PathVariable Long codigo) {
		return cidadeService.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Cidade> findAll(){
		return cidadeService.findAll();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long codigo){
		cidadeService.delete(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Cidade save(@RequestBody Cidade cidade){		
		return cidadeService.save(cidade);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Cidade cidade){
		cidadeService.save(cidade);
	}
}
