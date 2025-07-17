package com.ecosavers.demo.controller;
import com.ecosavers.demo.entity.Publicacion;
import com.ecosavers.demo.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/Publicaciones")
public class PublcacionController {

    @Autowired

    private PublicacionService publiService;

    @GetMapping("/getAll")
    public List<Publicacion> getAllPublicaciones(){return publiService.getAllpublicaciones();}

    @GetMapping("/getId")
    public ResponseEntity<Publicacion>getPublicacion(@RequestBody Long id){return ResponseEntity.ok(publiService.getPublicacion(id));}

    @PostMapping("/create")
    public ResponseEntity<Publicacion> createPublicacion(@RequestBody Publicacion publicacion){
        return ResponseEntity.ok(@RequestBody publiService.createPublicacion(publicacion));{
    }}
    @PostMapping("/update")
    public ResponseEntity<Publicacion> updatePublicacion(@RequestBody Publicacion publicacion) {
        return ResponseEntity.ok(@RequestBody publiService.updatePublicacion(publicacion));

    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePublicacion(@RequestParam Long id){
        publiService.deletePublicacion(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
}
