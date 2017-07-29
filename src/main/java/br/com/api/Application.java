package br.com.api;

import br.com.api.model.Usuario;
import br.com.api.service.UsuarioService;
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
    CommandLineRunner runner(UsuarioService userService) {
        return args -> {
            Usuario userAdmin = new Usuario("Administrador", "adm@adm.com", 
            		new BCryptPasswordEncoder().encode("admin"), "ROLE_ADMIN");            
            userAdmin.setId(1L);
            userService.save(userAdmin);
        };
    }

}
