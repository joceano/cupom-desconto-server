package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.User;
import br.com.api.service.SecurityService;
import br.com.api.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;   

    @RequestMapping(value = "logged", method = RequestMethod.GET)
    public ResponseEntity<?> user() {
        return ResponseEntity.ok(securityService.userLogged());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> users() {
        return ResponseEntity.ok(this.userService.find());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.save(user));
    }
    
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public User findOne(@PathVariable Long codigo){
		return userService.find(codigo);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> findAll(){
		return userService.findAll();							
	}
		
	@RequestMapping(value = "/{senha}", method = RequestMethod.POST)
	public User salvar(@RequestBody User user, @PathVariable String senha){		
		return userService.save(user, senha);
	}
	
	@RequestMapping(value = "/novo/{senha}", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String salvarNovoUsuario(@RequestBody User user, @PathVariable String senha){		
		return userService.salvarNovoUsuario(user, senha);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void edit(@RequestBody User user){
		userService.save(user);
	}

}
