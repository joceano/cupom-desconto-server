package br.com.api.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.User;
import br.com.api.repository.UserRepository;
import br.com.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {    	    	  
    	if (user.getId() == null) {
    		user.encryptPassword();
    	}        
        return this.userRepository.save(user);
    }

    @Override
    public User find(Long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public Collection<User> find() {
        return this.userRepository.findAll();
    }

	@Override
	public void delete(Long codigo) {
		userRepository.delete(codigo);		
	}

	@Override
	public void edit(User user) {
		userRepository.save(user);		
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user, String senha) {
		User usuario = tratarUsuario(user, senha);		    	
    	return this.userRepository.save(usuario);
	}

	@Override
	public String salvarNovoUsuario(User user, String senha) {
		User usuario = userRepository.findByUsername(user.getUsername());
		if (usuario == null) {
			usuario = tratarUsuario(user, senha);
			userRepository.save(user);
			return "O usuário " + usuario.getName() + " foi salvo com sucesso.";
		} else {
			return "Ops, seu usuário já foi cadastrado.";
		}
	}
	
	private User tratarUsuario(User user, String senha) {
		if (!senha.isEmpty()) {    		
			user.setPassword(senha);
			user.encryptPassword();
    	}

    	if (user.getCreated() == null) {
        	user.setCreated(new Date());    		
    	}
    	
    	if (user.getRoles() == null || user.getRoles().isEmpty()) {
    		user.setRoles(User.ROLE_USER);
    	}
		return user;
	}
}
