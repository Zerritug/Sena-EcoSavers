package com.ecosavers.demo.controller;

import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class AccountBlock {

    private final UsuarioRepository usuarioRepo;
    private int intentos;

    public AccountBlock(UsuarioRepository usuarioRepo) {
        this.intentos = 0;
        this.usuarioRepo = usuarioRepo;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void incrementarIntentos(String email) {
        this.intentos++;

        if (intentos >= 5) {
            Usuario usuario = usuarioRepo.findByEmail(email);
            if (usuario != null) {
                usuario.setBloqueo(LocalDateTime.now().plusMinutes(1)); //Configuracion de minutos
                usuarioRepo.save(usuario);
                System.out.println("Usuario bloqueado por intentos fallidos: " + email);
                System.out.println("Usuario bloqueado por " +  usuario.getBloqueo());
            }
        }
    }

    public void resetearIntentos() {
        this.intentos = 0;
    }
}
