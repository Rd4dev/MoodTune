package com.moodtune.controller;

import com.moodtune.dto.SongDTO;
import com.moodtune.model.Song;
import com.moodtune.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<SongDTO> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/withIds")
    public List<Song> getAllSongsWithIds() {
        return songService.getAllSongsWithIds();
    }

    @PostMapping
    public SongDTO addSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

    @GetMapping("/mood/{mood}")
    public List<SongDTO> getSongsByMood(@PathVariable("mood") String mood) {
        return songService.getSongsByMood(mood);
    }

    @GetMapping("/recommend/{mood}")
    public SongDTO findRandomSongByMood(@PathVariable("mood") String mood) {
        return songService.findRandomSongByMood(mood);
    }

    @PutMapping("/update/{id}")
    public SongDTO updateSong(@PathVariable("id") Long id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable("id") Long id) {
        songService.deleteSong(id);
    }
}
