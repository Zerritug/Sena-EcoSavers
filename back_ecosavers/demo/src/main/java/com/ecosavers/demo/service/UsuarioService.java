package com.ecosavers.demo.service;

import com.ecosavers.demo.dto.PasswordChangeRequest;
import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario getUsuarioByEmail(String email) {
        return usuarioRepo.findByEmail(email);
    }

    public Usuario createUsuario(Usuario usuario) {
        if (usuario.getPassword() == null || usuario.getEmail() == null) {
            throw new IllegalArgumentException("Email y contraseña son obligatorios");
        }
        usuario.setPassword(encodePassword(usuario.getPassword()));
        return usuarioRepo.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public Usuario deleteUsuario(Long id) {
        Usuario usuario = getUsuarioById(id);
        usuarioRepo.deleteById(id);
        return usuario;
    }

    public void changePassword(String email, PasswordChangeRequest request) {
        Usuario usuario = usuarioRepo.findByEmail(email);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        if (!verifyPassword(request.getOldPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña actual incorrecta");
        }

        usuario.setPassword(encodePassword(request.getNewPassword()));
        usuarioRepo.save(usuario);
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
