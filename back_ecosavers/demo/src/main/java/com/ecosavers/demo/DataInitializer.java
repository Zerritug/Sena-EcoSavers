package com.ecosavers.demo;

import com.ecosavers.demo.entity.Rol;
import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.repository.RolRepository;
import com.ecosavers.demo.repository.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder(); // ← aquí estás creando una instancia
    }
    @Bean
    public CommandLineRunner seed(RolRepository rolRepo, UsuarioRepository userRepo) {
        return args -> {
            // Verifica si ya existe el rol ADMIN
            if (rolRepo.findByName("ADMIN") == null) {
                Rol adminRol = new Rol("ADMIN");
                rolRepo.save(adminRol);

                Usuario user = new Usuario();
                user.setName("Runny");
                user.setEmail("runny@example.com");
                user.setTelNumber(1233232L);
                user.setEstado(true);
                user.setPassword(new BCryptPasswordEncoder().encode("12345"));
                user.setRol(adminRol);

                userRepo.save(user);

                System.out.println("Creado");
            } else {
                System.out.println("Error");
            }
        };
    }
}
