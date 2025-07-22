package com.ecosavers.demo.controller;
import com.ecosavers.demo.entity.Publicacion;
import com.ecosavers.demo.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/Publicaciones")
public class PublcacionController {

    @Autowired

    private PublicacionService publiService;

    @PreAuthorize("hasRole('ADMIN') or hasRole ('USUARIO')")
    @GetMapping("/getAll")
    public List<Publicacion> getAllPublicaciones(){return publiService.getAllpublicaciones();}

    @PreAuthorize("hasRole('ADMIN') or hasRole ('USUARIO')")
    @GetMapping("/getId")
    public ResponseEntity<Publicacion>getPublicacion(@RequestBody Long id){return ResponseEntity.ok(publiService.getPublicacion(id));}

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Publicacion> createPublicacion(@RequestBody Publicacion publicacion){
        return ResponseEntity.ok( publiService.createPublicacion(publicacion));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ResponseEntity<Publicacion> updatePublicacion(@RequestBody Publicacion publicacion) {
        return ResponseEntity.ok( publiService.updatePublicacion(publicacion));

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublicacion(@PathVariable Long id) {
        publiService.deletePublicacion(id);
        return ResponseEntity.ok("Publicación eliminada correctamente");
    }
}
