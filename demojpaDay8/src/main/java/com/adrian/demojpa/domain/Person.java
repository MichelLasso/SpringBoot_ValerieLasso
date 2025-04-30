package com.adrian.demojpa.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personas")
@EqualsAndHashCode(exclude = {"role"})
@ToString(exclude = {"role"})
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "full_name", columnDefinition = "text", length = 50, nullable = false)
    private String name;
    private String lastName;

    @Column(name = "programming_language")
    private String language;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rolId", nullable = false) // no permita valores nulos
    @JsonBackReference // Maca el lado que no se serializa
    private Rol role; // este es el que se usa en rol OneToMany mappedBy

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Passport passport;

    @ManyToMany
    @JoinTable(
        name= "persons_projects",
        joinColumns = @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name= "FK_personId_projects")),
        inverseJoinColumns = @JoinColumn(name= "project_id", foreignKey = @ForeignKey(name= "FK_projectId"))
    )
    @JsonBackReference
    private List<Project> projects = new ArrayList<>();
    public Person() {}

    public Person(Long id, String name, String lastName, String language) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
    }

}
