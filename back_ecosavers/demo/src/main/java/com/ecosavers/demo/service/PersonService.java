/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecosavers.demo.service;

/**
 *
 * @author cktv
 */
import com.ecosavers.demo.entity.Person;
import com.ecosavers.demo.entity.UserData;
import com.ecosavers.demo.repository.PersonRepository;
import com.ecosavers.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePersons(List<Long> ids) {
        personRepository.deleteAllById(ids);
    }

    public UserData createUser(Long personId, UserData user) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person not found"));
        user.setPerson(person);
        return userRepository.save(user);
    }

    public UserData updateUser(Long personId, UserData user) {
        UserData existingUser = userRepository.findByPersonId(personId);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long personId) {
        UserData user = userRepository.findByPersonId(personId);
        userRepository.delete(user);
    }

    public UserData getUserByPersonId(Long personId) {
        return userRepository.findByPersonId(personId);
    }
}

