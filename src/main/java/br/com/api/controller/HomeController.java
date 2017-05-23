package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Anuncio;
import br.com.api.service.HomeService;

@RestController
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Anuncio> findAll(){
		return homeService.findAll();							
	}

}
