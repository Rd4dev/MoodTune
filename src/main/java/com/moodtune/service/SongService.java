package com.moodtune.service;

import com.moodtune.dto.SongDTO;
import com.moodtune.model.Song;
import com.moodtune.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<SongDTO> getAllSongs() {
        return songRepository.findAll().stream()
                .map(song -> new SongDTO(song.getTitle(), song.getMood(), song.getVideoId()))
                .toList();
    }

    public List<Song> getAllSongsWithIds() {
        return songRepository.findAll();
    }

    public SongDTO saveSong(Song song) {
        Song savedSong = songRepository.save(song);
        return new SongDTO(savedSong.getTitle(), savedSong.getMood(), savedSong.getVideoId());
    }

    public List<SongDTO> getSongsByMood(String mood) {
        return songRepository.findByMood(mood).stream()
                .map(song -> new SongDTO(song.getTitle(), song.getMood(), song.getVideoId()))
                .toList();
    }

    public SongDTO findRandomSongByMood(String mood) {
        Song randomSong = songRepository.findRandomSongByMood(mood);
        return new SongDTO(randomSong.getTitle(), randomSong.getMood(), randomSong.getVideoId());
    }

    public SongDTO updateSong(Long id, Song song) {
        Song existing = songRepository.findById(id).orElseThrow();

        existing.setTitle(song.getTitle());
        existing.setMood(song.getMood());
        existing.setUrl(song.getVideoId());
        songRepository.save(existing);
        return new SongDTO(song.getTitle(), song.getMood(), song.getVideoId());
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
