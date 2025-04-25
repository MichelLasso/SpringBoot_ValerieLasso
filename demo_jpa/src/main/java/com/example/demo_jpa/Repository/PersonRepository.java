package com.example.demo_jpa.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_jpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String language);
    List<Person> findByIdEquals(Long id);
}
