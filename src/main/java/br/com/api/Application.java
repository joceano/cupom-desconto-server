package br.com.api;

import br.com.api.model.User;
import br.com.api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            User userAdmin = new User("Administrador", "adm@adm.com", 
            		new BCryptPasswordEncoder().encode("admin"), "ROLE_ADMIN");
            userAdmin.setId(1L);
            System.out.println("User admin criado: " + userService.save(userAdmin));
        	
            //TODO Esse usuário não precisa!
        	User user = new User("Joceano", "alves.joceano.borba12345@gmail.com", 
            		new BCryptPasswordEncoder().encode("123"), "ROLE_USER");
            user.setId(2L);
            System.out.println("User Joceano criado: " + userService.save(user));
        };
    }

}
