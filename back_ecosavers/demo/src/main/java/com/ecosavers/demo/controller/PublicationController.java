/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecosavers.demo.controller;

/**
 *
 * @author cktv
 */
import com.ecosavers.demo.entity.Publication;
import com.ecosavers.demo.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping("/getAll")
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/getIdCompany")
    public List<Publication> getPublicationsByCompany(@RequestParam Long companyId) {
        return publicationService.getPublicationsByCompany(companyId);
    }

    @GetMapping("/getIdCategory")
    public List<Publication> getPublicationsByCategory(@RequestParam Long categoryId) {
        return publicationService.getPublicationsByCategory(categoryId);
    }

    @PostMapping("/create")
    public ResponseEntity<Publication> createPublication(@RequestBody Publication publication) {
        return ResponseEntity.ok(publicationService.createPublication(publication));
    }

    @PutMapping("/update")
    public ResponseEntity<Publication> updatePublication(@RequestBody Publication publication) {
        return ResponseEntity.ok(publicationService.updatePublication(publication));
    }

    @GetMapping("/getId")
    public ResponseEntity<Publication> getPublicationById(@RequestParam Long id) {
        return ResponseEntity.ok(publicationService.getPublicationById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePublication(@RequestParam Long id) {
        publicationService.deletePublication(id);
        return ResponseEntity.ok("Publication deleted successfully.");
    }
}
