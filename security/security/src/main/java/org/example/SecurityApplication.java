package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class })
@EnableWebSecurity
@EnableJpaRepositories
@Configuration
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

//
//    @Bean
//    BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
//            userService.saveRole(new Role(null, "Role_USER"));
//            userService.saveRole(new Role(null, "Role_MANAGER"));
//            userService.saveRole(new Role(null, "Role_ADMIN"));
//            userService.saveRole(new Role(null, "Role_SUPER_ADMIN"));
//
//            userService.saveUser(new User(null, "Tien Dat", "DatVina", "Dat123@gmail.com", "123456", new HashSet<>()));
//            userService.saveUser(new User(null, "Van Hai", "HaiChieu", "Hai123@gmail.com", "123456", new HashSet<>()));
//
//            userService.addToUser("Dat123@gmail.com", "ROLE_USER");
//            userService.addToUser("Dat123@gmail.com", "ROLE_MANAGER");
//
//            userService.addToUser("Hai123@gmail.com", "ROLE_ADMIN");
//            userService.addToUser("Dat123@gmail.com", "ROLE_SUPER_ADMIN");
//
//        };
//    }
}
