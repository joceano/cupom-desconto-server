package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Categoria;
import br.com.api.service.CategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
		
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Categoria findOne(@PathVariable Long codigo){
		return categoriaService.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Categoria> findAll(){
		return categoriaService.findAll();
	}
		
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Categoria save(@RequestBody Categoria categoria){
		return categoriaService.save(categoria);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Categoria categoria){
		categoriaService.save(categoria);
	}
	
	@RequestMapping(value = "/autocomplete/{descricao}", method = RequestMethod.GET)
	public List<Categoria> findAutocomplete(@PathVariable String descricao){
		return categoriaService.findAutocomplete(descricao);
	}
}
