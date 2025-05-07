package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class type_options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String description;

    @Column(length = 80, nullable = false)
    private String tag_option;

    public type_options(Long id, String description, String tag_option) {
        this.id = id;
        this.description = description;
        this.tag_option = tag_option;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag_option() {
        return tag_option;
    }

    public void setTag_option(String tag_option) {
        this.tag_option = tag_option;
    }
}
