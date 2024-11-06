package mk.ukim.finki.lab1b.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1b.model.Artist;
import mk.ukim.finki.lab1b.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    private final List<Song> songs;

    public SongRepository() {
        this.songs = new ArrayList<>();
    }

    @PostConstruct
    public void init(){

        songs.add(new Song("1", "Bohemian Rhapsody", "Rock", 1975, new ArrayList<>()));
        songs.add(new Song("2", "I Will Always Love You", "Pop", 1992, new ArrayList<>()));
        songs.add(new Song("3", "Jailhouse Rock", "Rock and Roll", 1957, new ArrayList<>()));
        songs.add(new Song("4", "Respect", "Soul", 1967, new ArrayList<>()));
        songs.add(new Song("5", "Thriller", "Pop", 1982, new ArrayList<>()));
    }
    public List<Song> findAll(){
        return songs;
    }
    public Optional<Song> findByTrackId(String trackId){
        return songs.stream()
                .filter(s->s.getTrackId().equals(trackId))
                .findFirst();
    }
    public void addArtistToSong(Artist artist, Song song){
        song.getPerformers().removeIf(a->a.getId().equals(artist.getId()));
        song.getPerformers().add(artist);
    }
}
