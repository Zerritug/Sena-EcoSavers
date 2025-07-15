package com.ecosavers.demo.controller;

import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.security.JwtUtil;
import com.ecosavers.demo.dto.AuthRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.ecosavers.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepo;

    public AuthController(JwtUtil jwtUtil, UsuarioRepository usuarioRepo) {
        this.jwtUtil = jwtUtil;
        this.usuarioRepo = usuarioRepo;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {

        Usuario usuario = usuarioRepo.findByEmail(request.getUsername());

        if (usuario == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        if(usuario.getRol() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("No hay un usuario con ese rol");
        }

        String roleName = "ROLE_" + usuario.getRol().getName();
        List<String> roles = List.of(roleName);

        String token = jwtUtil.generateToken(usuario.getEmail(), roles);

        // Validación y generación de token...
        return ResponseEntity.ok(token);
    }
}
