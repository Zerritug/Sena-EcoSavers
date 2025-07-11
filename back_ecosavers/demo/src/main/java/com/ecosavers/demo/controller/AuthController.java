package com.ecosavers.demo.controller;

import com.ecosavers.demo.security.JwtUtil;
import com.ecosavers.demo.dto.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        // Aquí puedes validar usuario y contraseña con tu base de datos
        String token = jwtUtil.generateToken(request.getUsername(),request.getPassword());
        return ResponseEntity.ok(token);
    }
}
