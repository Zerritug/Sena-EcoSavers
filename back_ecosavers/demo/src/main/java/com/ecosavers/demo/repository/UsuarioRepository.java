package com.ecosavers.demo.repository;
import com.ecosavers.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
     Usuario findByEmail(String email);

}
