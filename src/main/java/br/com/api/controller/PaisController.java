package br.com.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.model.Pais;
import br.com.api.repository.PaisRepository;

@RestController
@RequestMapping("pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Pais findOne(@PathVariable Long codigo) {
		return paisRepository.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Pais> findAll(){
		return paisRepository.findAll();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long codigo){
		paisRepository.delete(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Pais save(@RequestBody Pais pais){
		paisRepository.save(pais);
		return pais;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Pais pais){
		paisRepository.save(pais);
	}

}
