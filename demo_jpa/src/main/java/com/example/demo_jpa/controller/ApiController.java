package com.example.demo_jpa.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_jpa.Repository.PersonRepository;
import com.example.demo_jpa.domain.Person;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value= "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonRepository personRepository;

    public ApiController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // http://localhost:8080/api/users
    @RequestMapping(value = "/users")
    public List<Person> findAll() {
        List<Person> results= personRepository.findByLanguageEquals("Java");
        return results;
    }
    // http://localhost:8080/api/id
    @RequestMapping(value = "/id")
    public List<Person> findId(){
        List<Person> rPersons= personRepository.findByIdEquals(1L);
        return rPersons;
    }
    // http://localhost:8080/api/name
    @RequestMapping(value = "/name")
    public List<Person> findName(){
        List<Person> rPersonsName= personRepository.findByNameContains("y");
        return rPersonsName;
    }
    
}
