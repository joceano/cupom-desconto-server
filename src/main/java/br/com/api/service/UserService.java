package br.com.api.service;

import br.com.api.model.User;

import java.util.Collection;

public interface UserService {

    User save(User user);

    User find(Long id);

    Collection<User> find();

}
