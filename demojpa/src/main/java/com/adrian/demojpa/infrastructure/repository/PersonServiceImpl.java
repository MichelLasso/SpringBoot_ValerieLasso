package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.domain.dto.PersonRequest;
import com.adrian.demojpa.infrastructure.error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllUsersByFilter(String filter, String value) {
        if(filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        } else if(filter.toLowerCase().equals("language") && !value.isEmpty()) {
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

    @Override
    public Person patchPerson(Long id, PersonRequest personRequest) {
        Person pOptional= personRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encontró el usuario solicitado"));

        if (personRequest.getName() != null) {
            pOptional.setName(personRequest.getName());
        }

        if (personRequest.getSurname() != null) {
            pOptional.setLastName(null);(personRequest.getSurname());
        }

        if (personRequest.getSkill() != null) {
            pOptional.setLanguage(personRequest.getSkill());
        }

        personRepository.save(pOptional);
        return pOptional;
    }

    
}