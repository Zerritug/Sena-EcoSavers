/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecosavers.demo.controller;

/**
 *
 * @author cktv
 */
import com.ecosavers.demo.entity.Company;
import com.ecosavers.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/getAll")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.createCompany(company));
    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.updateCompany(company));
    }

    @GetMapping("/getId")
    public ResponseEntity<Company> getCompanyById(@RequestParam Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCompany(@RequestParam Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Company deleted successfully.");
    }
}
