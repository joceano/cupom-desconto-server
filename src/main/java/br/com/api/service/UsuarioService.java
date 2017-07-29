package br.com.api.service;

import java.util.Collection;
import java.util.List;

import br.com.api.model.Usuario;

public interface UsuarioService {

    Usuario save(Usuario user);
    
    Usuario save(Usuario user, String senha);
    
    String salvarNovoUsuario(Usuario user, String senha);

    Usuario find(Long id);

    Collection<Usuario> find();
	
	void delete(Long codigo);		
	
	void edit(Usuario user);
	
	List<Usuario> findAll();	

}
