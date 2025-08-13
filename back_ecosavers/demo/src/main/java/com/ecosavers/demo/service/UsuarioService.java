package com.ecosavers.demo.service;
import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario deleteUsuario(Long id) {
        Usuario usuario = getUsuarioById(id);
        usuarioRepo.deleteById(id);
        return usuario;
    }
}
