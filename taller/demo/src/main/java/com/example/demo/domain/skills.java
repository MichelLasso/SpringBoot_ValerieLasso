package com.example.demo.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime updated_at;

    @Column(nullable = false, length = 80)
    private String iconurl;

    @Column(nullable = false, length = 80)
    private String skill_name;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String skill_description;

    public skills(Long id, LocalDateTime created_at, LocalDateTime updated_at, String iconurl, String skill_name,
            String skill_description) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.iconurl = iconurl;
        this.skill_name = skill_name;
        this.skill_description = skill_description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_description() {
        return skill_description;
    }

    public void setSkill_description(String skill_description) {
        this.skill_description = skill_description;
    }

    
}
