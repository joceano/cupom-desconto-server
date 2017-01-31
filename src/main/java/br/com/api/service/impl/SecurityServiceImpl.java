package br.com.api.service.impl;

import br.com.api.model.User;
import br.com.api.repository.UserRepository;
import br.com.api.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User userLogged() {
        String login = null;
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                login = authentication.getName();
            }
        }
        return userRepository.findByUsername(login);
    }

}
