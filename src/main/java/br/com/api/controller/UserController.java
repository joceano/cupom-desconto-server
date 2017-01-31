package br.com.api.controller;

import br.com.api.model.User;
import br.com.api.service.SecurityService;
import br.com.api.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    private final Logger logger = Logger.getLogger(this.getClass());

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

}
