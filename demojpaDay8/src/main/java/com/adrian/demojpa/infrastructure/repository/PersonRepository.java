package com.adrian.demojpa.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String name);
}