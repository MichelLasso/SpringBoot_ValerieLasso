package com.adrian.demojpa.infrastructure.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.application.service.ProjectService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Project;
import com.adrian.demojpa.domain.Rol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonService personService;
    private final ProjectService projectService;
    //@Qualifier("personServicePImpl") 

    public ApiController(PersonService personService, ProjectService projectService) {
        this.personService = personService;
        this.projectService = projectService;
    }
    // http://localhost:8080/api/users
    @GetMapping("/users")    
    public List<Person> findAll(
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ) {

        List<Person> results = personService.findAllUsersByFilter(filter, value);

        return results;
    }
    // http://localhost:8080/api/roles
    @GetMapping("/roles")    
    public List<Rol> findAllRoles(
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ) {

        List<Rol> results = personService.findAllRolesByFilter(filter, value);

        return results;
    }

    @PostMapping("/roles")
    public Map<String, String> newRole (@RequestBody Rol rol) {
        return Map.of("ID", rol.getId(), "name", rol.getName());
    }

    // http://localhost:8080/api/projects
    @GetMapping("/projects")    
    public List<Project> findAllProjects(
        @RequestParam(name= "filter", defaultValue = "") String filter,
        @RequestParam(name="value", defaultValue = "") String value
    ) {

        List<Project> results = projectService.findAllProjects();

        return results;
    }
}
