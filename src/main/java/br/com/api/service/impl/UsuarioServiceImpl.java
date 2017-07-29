package br.com.api.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;
import br.com.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public Usuario save(Usuario user) {    	    	  
    	if (user.getId() == null) {
    		user.encryptPassword();
    	}        
        return this.userRepository.save(user);
    }

    @Override
    public Usuario find(Long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public Collection<Usuario> find() {
        return this.userRepository.findAll();
    }

	@Override
	public void delete(Long codigo) {
		userRepository.delete(codigo);		
	}

	@Override
	public void edit(Usuario user) {
		userRepository.save(user);		
	}

	@Override
	public List<Usuario> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Usuario save(Usuario user, String senha) {
		Usuario usuario = tratarUsuario(user, senha);		    	
    	return this.userRepository.save(usuario);
	}

	@Override
	public String salvarNovoUsuario(Usuario user, String senha) {
		Usuario usuario = userRepository.findByUsername(user.getUsername());
		if (usuario == null) {
			usuario = tratarUsuario(user, senha);
			userRepository.save(user);
			return "O usuário " + usuario.getName() + " foi salvo com sucesso.";
		} else {
			return "Ops, seu usuário já foi cadastrado.";
		}
	}
	
	private Usuario tratarUsuario(Usuario user, String senha) {
		if (!senha.isEmpty()) {    		
			user.setPassword(senha);
			user.encryptPassword();
    	}

    	if (user.getCreated() == null) {
        	user.setCreated(new Date());    		
    	}
    	
    	if (user.getRoles() == null || user.getRoles().isEmpty()) {
    		user.setRoles(Usuario.ROLE_USER);
    	}
		return user;
	}
}
