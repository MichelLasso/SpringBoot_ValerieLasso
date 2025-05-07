package com.example.demo.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class media_sub_chapters {
/* 
    @ManyToOne
    @JoinColumn(name= "media_id")
    private media_types mediaTypes;

    /*@ManyToOne
    @JoinColumn(name = "subchapter_id")
    private 

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime updated_at;

    @Column(length = 80, nullable = false)
    private String description;

    @Lob
    @Column( nullable = false ,columnDefinition = "TEXT")
    private String summary;

    public media_sub_chapters(Long media_id, Long subchapter_id, LocalDateTime created_at, LocalDateTime updated_at,
            String description, String summary) {
        this.media_id = media_id;
        this.subchapter_id = subchapter_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.summary = summary;
    }

    public Long getMedia_id() {
        return media_id;
    }

    public void setMedia_id(Long media_id) {
        this.media_id = media_id;
    }

    public Long getSubchapter_id() {
        return subchapter_id;
    }

    public void setSubchapter_id(Long subchapter_id) {
        this.subchapter_id = subchapter_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    */
}
