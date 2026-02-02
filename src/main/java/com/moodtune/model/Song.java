package com.moodtune.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String mood;
    private String videoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setUrl(String videoId) {
        this.videoId = videoId;
    }
}
