package br.com.api.service.impl;

import br.com.api.model.User;
import br.com.api.repository.UserRepository;
import br.com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        if (user.getId() == null) user.encryptPassword();
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
}
