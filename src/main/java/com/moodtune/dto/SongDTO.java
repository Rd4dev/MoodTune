package com.moodtune.dto;

public class SongDTO {
    private String title;
    private String mood;
    private String videoId;

    public SongDTO(String title, String mood, String videoId) {
        this.title = title;
        this.mood = mood;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public String getMood() {
        return mood;
    }

    public String getVideoId() {
        return videoId;
    }
}
