package com.example.demo_jpa.infrastructure.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_jpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    List<Person> findByNameContains(String name);
    List<Person> findByNameEquals(String name);
    List<Person> findByIdEquals(Long id);
    List<Person> findByLanguageEquals(String name);
}
