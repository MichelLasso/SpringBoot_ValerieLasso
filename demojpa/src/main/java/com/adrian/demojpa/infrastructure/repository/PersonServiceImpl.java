package com.adrian.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.adrian.demojpa.application.service.PersonService;
import com.adrian.demojpa.domain.Passport;
import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;
import com.adrian.demojpa.domain.dto.PersonRequest;
import com.adrian.demojpa.domain.dto.PersonResponse;
import com.adrian.demojpa.infrastructure.error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final DocumentRepository documentRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository, DocumentRepository documentRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.documentRepository= documentRepository;
    }

    @Override
    public List<PersonResponse> findAllUsersByFilter(String filter, String value) {
        
        if(filter.toLowerCase().equals("name") && !value.isEmpty()) {
           
            return personRepository.findByNameContains(value).stream().map((person) ->{
                
                PersonResponse rPersonResponse =  new PersonResponse();
                rPersonResponse.setName(person.getName());
                rPersonResponse.setSurname(person.getLastName());
                rPersonResponse.setSkill(person.getLanguage());
                rPersonResponse.setPassport(person.getPassport() != null);
                
                return rPersonResponse;

            }).toList();

        } else if(filter.toLowerCase().equals("language") && !value.isEmpty()) {
            
            return personRepository.findByLanguageEquals(value).stream().map((person) ->{
                
                PersonResponse rPersonResponse =  new PersonResponse();
                rPersonResponse.setName(person.getName());
                rPersonResponse.setSurname(person.getLastName());
                rPersonResponse.setSkill(person.getLanguage());
                rPersonResponse.setPassport(person.getPassport() != null);
                
                return rPersonResponse;

            }).toList();
        }
        
        return personRepository.findAll().stream().map((person) -> {
            PersonResponse rPersonResponse =  new PersonResponse();
                rPersonResponse.setName(person.getName());
                rPersonResponse.setSurname(person.getLastName());
                rPersonResponse.setSkill(person.getLanguage());
                rPersonResponse.setPassport(person.getPassport() != null);
                return rPersonResponse;
            }).toList();
    }

    @Override
    public PersonResponse patchPerson(Long id, PersonRequest personRequest) {
        Person pOptional= personRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("No se encontró el usuario solicitado"));

        if (personRequest.getName() != null) {
            pOptional.setName(personRequest.getName());
        }

        if (personRequest.getSurname() != null) {
            pOptional.setLastName((personRequest.getSurname()));
        }

        if (personRequest.getSkill() != null) {
            pOptional.setLanguage(personRequest.getSkill());
        }

        personRepository.save(pOptional);
        PersonResponse rPersonResponse =  new PersonResponse();
        rPersonResponse.setName(pOptional.getName());
        rPersonResponse.setSurname(pOptional.getLastName());
        rPersonResponse.setSkill(pOptional.getLanguage());
        rPersonResponse.setPassport(pOptional.getPassport() != null);
        return rPersonResponse;
    }

    @Override
    public PersonResponse createNewUsers(PersonRequest personDto) {
        Optional<Person> persOptional= personRepository.findByPassportNumber(personDto.getPassport());

        // validamos si el usuario no este registrado
        if (persOptional.isPresent()) {
            throw new RolDuplicateException("El usuario ya se encuenra registrado", HttpStatus.CONFLICT);

        }
        // buscamos el rol para el usuario
        Rol useRol= roleRepository.findById(1L).orElseThrow(()-> new EntityNotFoundException("No se encuentra el rol"));
        
        // creamos el usuario temporal
        Person nPerson= new Person();
        nPerson.setName(personDto.getName());
        nPerson.setLastName(personDto.getSurname());
        nPerson.setLanguage(personDto.getSkill());
        nPerson.setRole(useRol);

        //guardamos nuestro nuevo regsitro
        Person save = personRepository.save(nPerson);

        // creamos el pasaporte temporal
        Passport passport = new Passport();
        passport.setPerson(nPerson);
        passport.setNumber(personDto.getPassport());

        //guardar el passport o el documento
        documentRepository.save(passport);
        
        // mapeor de person a personrespnse
        save.setPassport(passport);
        PersonResponse rPersonResponse =  new PersonResponse();
        rPersonResponse.setName(save.getName());
        rPersonResponse.setSurname(save.getLastName());
        rPersonResponse.setSkill(save.getLanguage());
        rPersonResponse.setPassport(save.getPassport() != null);
        return rPersonResponse;
    }

    
}