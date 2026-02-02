package com.moodtune.service;

import com.moodtune.dto.SongDTO;
import com.moodtune.model.Song;
import com.moodtune.repository.SongRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SongServiceTest {
    private SongRepository songRepository;
    private SongService songService;

    @BeforeEach
    void setUp() {
        songRepository = mock(SongRepository.class);
        songService = new SongService(songRepository);
    }

    @Test
    void testGetAllSongsDTO() {
        Song song1 = new Song();
        song1.setTitle("Happy Song");
        song1.setMood("happy");
        song1.setUrl("url1");

        Song song2 = new Song();
        song2.setTitle("Sad Song");
        song2.setMood("sad");
        song2.setUrl("url2");

        when(songRepository.findAll()).thenReturn(List.of(song1, song2));

        List<SongDTO> dtos = songService.getAllSongs();

        assertEquals(2, dtos.size());
        assertEquals("Happy Song", dtos.get(0).getTitle());
        assertEquals("happy", dtos.get(0).getMood());
        assertEquals("url2", dtos.get(1).getVideoId());
    }

    @Test
    void testGetSongsByMoodDTO() {
        Song song = new Song();
        song.setTitle("Happy Song");
        song.setMood("happy");
        song.setUrl("url1");

        when(songRepository.findByMood("happy")).thenReturn(List.of(song));

        List<SongDTO> dtos = songService.getSongsByMood("happy");

        assertEquals(1, dtos.size());
        assertEquals("Happy Song", dtos.get(0).getTitle());
        assertEquals("happy", dtos.get(0).getMood());
        assertEquals("url1", dtos.get(0).getVideoId());
    }

    @Test
    void testSaveSong() {
        Song song = new Song();
        song.setTitle("New Song");
        song.setMood("pop");
        song.setUrl("url3");

        when(songRepository.save(song)).thenReturn(song);

        SongDTO dto = songService.saveSong(song);

        assertEquals("New Song", dto.getTitle());
        assertEquals("pop", dto.getMood());
        assertEquals("url3", dto.getVideoId());

        verify(songRepository, times(1)).save(song);
    }
}
