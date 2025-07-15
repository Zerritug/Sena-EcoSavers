package com.ecosavers.demo.service;
import java.util.List;
import com.ecosavers.demo.entity.Categoria;
import com.ecosavers.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRep;

    public CategoriaService(CategoriaRepository categoriaRep){
        this.categoriaRep = categoriaRep;
    }
    public List<Categoria>getAllCategorias(){return categoriaRep.findAll();}

    public Categoria deleteCategoria(Long id){
        Categoria categoria = categoriaRep.findById(id).orElse(null);
        if (categoria != null){
            categoriaRep.deleteById(id);
        }
        return categoria;
    }

    public Categoria createCategoria(Categoria categoria){
        return categoriaRep.save(new Categoria(categoria.getName()));
    }
}
