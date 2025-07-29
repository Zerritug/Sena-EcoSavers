package com.ecosavers.demo.repository;

import com.ecosavers.demo.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByName(String name);
}
