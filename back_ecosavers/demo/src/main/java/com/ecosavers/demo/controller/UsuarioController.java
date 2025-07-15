package com.ecosavers.demo.controller;

import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/Usuarios")
public class UsuarioController {

    @Autowired

    private UsuarioService usuarioService;

    @GetMapping("/getAll")
    public List<Usuario> getAllUsuarios(){return usuarioService.getAllUsuarios();}


    @PostMapping("/create")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @PostMapping("/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }

    @PostMapping("/getId")
    public ResponseEntity<Usuario> getUsuarioById(@RequestBody Long id){
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUsuario(@RequestParam Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }

}


