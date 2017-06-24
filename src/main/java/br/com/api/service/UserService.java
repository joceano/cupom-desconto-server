package br.com.api.service;

import java.util.Collection;
import java.util.List;

import br.com.api.model.User;

public interface UserService {

    User save(User user);
    
    User save(User user, String senha);
    
    String salvarNovoUsuario(User user, String senha);

    User find(Long id);

    Collection<User> find();
	
	void delete(Long codigo);		
	
	void edit(User user);
	
	List<User> findAll();	

}
