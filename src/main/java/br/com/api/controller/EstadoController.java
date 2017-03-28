package br.com.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.model.Estado;
import br.com.api.repository.EstadoRepository;

@RestController
@RequestMapping("estado")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Estado findOne(@PathVariable Long codigo) {
		return estadoRepository.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Estado> findAll(){
		return estadoRepository.findAll();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long codigo){
		estadoRepository.delete(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Estado save(@RequestBody Estado estado){
		estadoRepository.save(estado);
		return estado;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Estado estado){
		estadoRepository.save(estado);
	}

}
