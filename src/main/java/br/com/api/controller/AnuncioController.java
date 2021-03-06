package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.model.Anuncio;
import br.com.api.service.AnuncioService;

@RestController
@RequestMapping("anuncio")
public class AnuncioController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public Anuncio findOne(@PathVariable Long codigo){
		return anuncioService.findOne(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Anuncio> findAll(){
		return anuncioService.findAll();							
	}
		
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Anuncio save(@RequestBody Anuncio anuncio){		
		return anuncioService.save(anuncio);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody Anuncio anuncio){
		anuncioService.save(anuncio);
	}
	
	@RequestMapping(value = "/upload/{codigo}", method = RequestMethod.POST) 
    public void upload(@PathVariable Long codigo,
    		@RequestParam("uploadfile") MultipartFile uploadfile) throws Exception {		
		anuncioService.upload(codigo, uploadfile);		
	}
}
