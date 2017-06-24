package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Estado;
import br.com.api.service.EstadoService;

@RestController
@RequestMapping("estado")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Estado findOne(@PathVariable Long codigo) {
		return estadoService.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Estado> findAll(){
		return estadoService.findAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Estado save(@RequestBody Estado estado){		
		return estadoService.save(estado);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Estado estado){
		estadoService.save(estado);
	}
}
