package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Artist;
import mk.ukim.finki.lab1b.model.Song;
import mk.ukim.finki.lab1b.repository.ArtistRepository;
import mk.ukim.finki.lab1b.repository.SongRepository;
import mk.ukim.finki.lab1b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ISongService implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public ISongService(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void FindAndAddArtistToSong(String artistId, String trackId) {
        Artist artist = artistRepository.findById(Long.parseLong( artistId)).orElseThrow(RuntimeException::new);
        Song song = songRepository.findByTrackId(trackId).orElseThrow(RuntimeException::new);
        this.AddArtistToSong(artist,song);
    }

    public void AddArtistToSong(Artist artist, Song song) {
        songRepository.addArtistToSong(artist,song);
    }

    @Override
    public Optional<Song> findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
}
