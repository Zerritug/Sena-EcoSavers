/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecosavers.demo.service;

/**
 *
 * @author cktv
 */
import com.ecosavers.demo.entity.Publication;
import com.ecosavers.demo.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    public List<Publication> getPublicationsByCompany(Long companyId) {
        return publicationRepository.findByUser_Person_Company_Id(companyId);
    }

    public List<Publication> getPublicationsByCategory(Long categoryId) {
        return publicationRepository.findByCategory_Id(categoryId);
    }

    public Publication createPublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    public Publication updatePublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    public Publication getPublicationById(Long id) {
        return publicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Publication not found"));
    }

    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }
}

