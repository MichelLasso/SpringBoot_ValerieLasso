package com.example.demo_jpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_jpa.application.service.PersonService;
import com.example.demo_jpa.domain.Person;
import com.example.demo_jpa.infrastructure.Repository.PersonRepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value= "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonRepository personRepository;
    private final PersonService personService;
    
    public ApiController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }
    // http://localhost:8080/api/users // all
    // http://localhost:8080/api/users?filter=language&value=python 
    // http://localhost:8080/api/users?filter=a // valerie
    @RequestMapping(value = "/users")
    public List<Person> findAll(
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name= "value", defaultValue = "") String value
    ) {
        List<Person> results= personService.findAllByFilter(filter, value);
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
