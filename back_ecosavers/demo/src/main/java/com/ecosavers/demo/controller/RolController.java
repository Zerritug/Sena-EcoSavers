package com.ecosavers.demo.controller;

import com.ecosavers.demo.entity.Rol;
import com.ecosavers.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/getAll")
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

        @PostMapping("/create")
        public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
            return ResponseEntity.ok(rolService.createRole(rol));
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rol> deleteRole(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.deleteRole(rol.getId()));
    }
}


