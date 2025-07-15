package com.ecosavers.demo.controller;
import com.ecosavers.demo.entity.Categoria;
import com.ecosavers.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/getAll")
    public List<Categoria>getAllCategorias(){return categoriaService.getAllCategorias();}


    @PostMapping("/create")
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.createCategoria(categoria));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteCategoria(@RequestParam Long id){
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok( "Categoria eliminada correctamente");
    }
}
