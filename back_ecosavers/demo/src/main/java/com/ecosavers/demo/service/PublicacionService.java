package com.ecosavers.demo.service;
import com.ecosavers.demo.entity.Publicacion;
import com.ecosavers.demo.entity.Usuario;
import com.ecosavers.demo.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublicacionService {

    private final PublicacionRepository PublicationRepo;

    @Autowired
    public PublicacionService(PublicacionRepository publicationRepo){
        this.PublicationRepo = publicationRepo;
    }

    public List<Publicacion> getAllpublicaciones() {
        return PublicationRepo.findAll();
    }
    public Publicacion getPublicacion(Long id) {
        return PublicationRepo.findById(id).orElseThrow(() -> new RuntimeException("Publicacion no encontrado"));
    }

    public Publicacion createPublicacion (Publicacion publicacion) {
        return PublicationRepo.save(publicacion);
    }

    public Publicacion updatePublicacion(Publicacion publicacion) {
        return PublicationRepo.save(publicacion);
    }

    public Publicacion getUsuarioById(Long id) {
        return PublicationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Publicacion deletePublicacion(Long id) {
        Publicacion publicacion = getUsuarioById(id);
        PublicationRepo.deleteById(id);
        return publicacion;
    }
}
