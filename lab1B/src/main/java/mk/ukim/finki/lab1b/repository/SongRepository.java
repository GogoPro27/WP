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

    public List<Song> findAll(){
        return songs;
    }
    public Optional<Song> findByTrackId(String trackId){
        return songs.stream()
                .filter(s->s.getTrackId().equals(trackId))
                .findFirst();
    }
    public Optional<Song> findById(long id){
        return songs.stream()
                .filter(s->s.getId().equals(id))
                .findFirst();
    }
    public void addArtistToSong(Artist artist, Song song){
        song.getPerformers().removeIf(a->a.getId().equals(artist.getId()));
        song.getPerformers().add(artist);
    }
    public void save(Song song){
        songs.removeIf(s->s.getId().equals(song.getId()));
        songs.add(song);
    }
    public void deleteById(long id){
        songs.removeIf(s->s.getId().equals(id));
    }
    public void removePerformerFromSong(long songId,long artistId){
        songs.stream()
                .filter(s->s.getId().equals(songId))
                .findFirst()
                .orElseThrow()
                .getPerformers().removeIf(p->p.getId().equals(artistId));
    }
}
