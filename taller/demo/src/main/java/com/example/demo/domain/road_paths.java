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
public class road_paths {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isactive;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime updated_at;

    @Column(length = 80)
    private String image_path;
    @Column(length = 80, nullable = false)
    private String path_name;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;


    public road_paths(Long id, boolean isactive, LocalDateTime created_at, LocalDateTime updated_at, String image_path,
            String path_name, String description) {
        this.id = id;
        this.isactive = isactive;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.image_path = image_path;
        this.path_name = path_name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
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

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getPath_name() {
        return path_name;
    }

    public void setPath_name(String path_name) {
        this.path_name = path_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
