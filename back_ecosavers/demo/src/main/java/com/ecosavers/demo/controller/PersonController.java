/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecosavers.demo.controller;

/**
 *
 * @author cktv
 */
import com.ecosavers.demo.entity.Person;
import com.ecosavers.demo.entity.UserData;
import com.ecosavers.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }


    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.updatePerson(person));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePersons(@RequestBody List<Long> ids) {
        personService.deletePersons(ids);
        return ResponseEntity.ok("Persons deleted successfully.");
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserData> createUser(@RequestParam Long personId, @RequestBody UserData user) {
        return ResponseEntity.ok(personService.createUser(personId, user));
    }

    @PutMapping("/update-user")
    public ResponseEntity<UserData> updateUser(@RequestParam Long personId, @RequestBody UserData user) {
        return ResponseEntity.ok(personService.updateUser(personId, user));
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@RequestParam Long personId) {
        personService.deleteUser(personId);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping("/getIdUser")
    public ResponseEntity<UserData> getUserByPersonId(@RequestParam Long personId) {
        return ResponseEntity.ok(personService.getUserByPersonId(personId));
    }
}

