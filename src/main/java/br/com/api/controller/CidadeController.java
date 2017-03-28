package br.com.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.model.Cidade;
import br.com.api.repository.CidadeRepository;

@RestController
@RequestMapping("cidade")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Cidade findOne(@PathVariable Long codigo) {
		return cidadeRepository.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Cidade> findAll(){
		return cidadeRepository.findAll();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long codigo){
		cidadeRepository.delete(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Cidade save(@RequestBody Cidade cidade){
		cidadeRepository.save(cidade);
		return cidade;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Cidade cidade){
		cidadeRepository.save(cidade);
	}
}
