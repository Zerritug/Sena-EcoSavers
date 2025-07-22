package com.ecosavers.demo.controller;

import com.ecosavers.demo.dto.TokenResponse;
import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.security.JwtUtil;
import com.ecosavers.demo.dto.AuthRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<TokenResponse> login(@RequestBody AuthRequest request) {

        Usuario usuario = usuarioRepo.findByEmail(request.getUsername());

        if (usuario == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if(usuario.getRol() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String roleName = "ROLE_" + usuario.getRol().getName();
        List<String> roles = List.of(roleName);

        String token = jwtUtil.generateToken(usuario.getEmail(), roles);
        System.out.println("🔑 Token generado: " + token);

        return ResponseEntity.ok(new TokenResponse(token));

    }


    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshAccessToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");

        try {
            String username = jwtUtil.extractUsername(refreshToken);


            if (!jwtUtil.validateToken(refreshToken, username)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no válido.");
            }

            Claims claims = jwtUtil.extractAllClaims(refreshToken);
            List<String> roles = claims.get("roles", List.class);

            String newAccessToken = jwtUtil.generateToken(username, roles);


            return ResponseEntity.ok(Map.of("accessToken", newAccessToken));

        } catch (ExpiredJwtException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh Token expirado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh Token inválido.");
        }
    }
}
