package com.ecosavers.demo.service;

import com.ecosavers.demo.entity.Rol;
import com.ecosavers.demo.repository.RolRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepo;



    public RolService(RolRepository rolRepo) {
        this.rolRepo = rolRepo;
    }

    public List<Rol> getAllRoles() {
        return rolRepo.findAll();
    }

    public Rol deleteRole(Long id) {
        Rol rol = rolRepo.findById(id).orElse(null);
        if (rol != null) {
            rolRepo.deleteById(id);
        }
        return rol;
    }

    public Rol createRole(Rol rol) {
        return rolRepo.save(new Rol(rol.getName()));
    }
}

