package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Artist;
import mk.ukim.finki.lab1b.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService{
    List<Song> listSongs();
    void FindAndAddArtistToSong(String artistId, String trackId);
    Optional<Song> findByTrackId(String trackId);
}
