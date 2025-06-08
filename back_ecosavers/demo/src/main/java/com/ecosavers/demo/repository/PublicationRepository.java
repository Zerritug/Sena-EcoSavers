/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecosavers.demo.repository;

/**
 *
 * @author cktv
 */
import com.ecosavers.demo.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByUser_Person_Company_Id(Long companyId);
    List<Publication> findByCategory_Id(Long categoryId);
}

