package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Categoria;
import br.com.api.repository.CategoriaRepository;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
		
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Categoria findOne(@PathVariable Long codigo){
		return categoriaRepository.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
		
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long codigo){
		categoriaRepository.delete(codigo);
	}
		
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void save(@RequestBody Categoria categoria){
		categoriaRepository.save(categoria);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Categoria categoria){
		categoriaRepository.save(categoria);
	}
}
