package com.example.demo_jpa.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Persons")
public class Person {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincrement
    private Long id;
    private String name;
    private String lastName;
    
    @Column(name = "programming_language")
    private String language;

    @OneToMany
    private List<Rol> rol;

    public Person(){}

    public Person(Long id, String name, String lastName, String language, List<Rol> rol) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    

    
}
