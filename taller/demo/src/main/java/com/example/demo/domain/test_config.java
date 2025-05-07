package com.example.demo.domain;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class test_config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(columnDefinition = "DATE")
    private String and_date;
    
    private Boolean is_active;
    
    @Column(length = 4)
    private Integer score;

    @CreationTimestamp
    @Column(columnDefinition = "DATE")
    private String strart_date;

    @Column(length = 90, nullable = false)
    private String description;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String test_summary;

    public test_config(Long id, String and_date, Boolean is_active, Integer score, String strart_date,
            String description, String test_summary) {
        this.id = id;
        this.and_date = and_date;
        this.is_active = is_active;
        this.score = score;
        this.strart_date = strart_date;
        this.description = description;
        this.test_summary = test_summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnd_date() {
        return and_date;
    }

    public void setAnd_date(String and_date) {
        this.and_date = and_date;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStrart_date() {
        return strart_date;
    }

    public void setStrart_date(String strart_date) {
        this.strart_date = strart_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTest_summary() {
        return test_summary;
    }

    public void setTest_summary(String test_summary) {
        this.test_summary = test_summary;
    }

    
}
