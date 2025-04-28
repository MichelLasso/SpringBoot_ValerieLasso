package com.example.demo_jpa.application.service;

import java.nio.file.DirectoryStream.Filter;
import java.util.List;

import com.example.demo_jpa.domain.Person;
import com.example.demo_jpa.infrastructure.Repository.PersonRepository;

// son componentes que contienen la lógica de negocio de la aplicacióon
public interface PersonService {
    List<Person> findAllByFilter(String filter, String value);
}
