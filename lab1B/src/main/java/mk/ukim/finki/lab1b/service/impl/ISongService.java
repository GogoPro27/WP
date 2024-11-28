package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Album;
import mk.ukim.finki.lab1b.model.Artist;
import mk.ukim.finki.lab1b.model.Song;
import mk.ukim.finki.lab1b.repository.AlbumRepository;
import mk.ukim.finki.lab1b.repository.ArtistRepository;
import mk.ukim.finki.lab1b.repository.SongRepository;
import mk.ukim.finki.lab1b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ISongService implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public ISongService(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void findAndAddArtistToSong(Long artistId, Long songId) {
        System.out.println(artistId+ " iiii "+ songId);
        Artist artist = artistRepository.findById(artistId).orElseThrow(RuntimeException::new);
        Song song = songRepository.findById(songId).orElseThrow(RuntimeException::new);
        this.AddArtistToSong(artist,song);
    }

    public void AddArtistToSong(Artist artist, Song song) {
        songRepository.addArtistToSong(artist,song);
    }

    @Override
    public Optional<Song> findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public Optional<Song> findById(long id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void save(Long id,String title, String trackId, String genre, int releaseYear, Long albumId) {
        Song newSong = new Song(trackId,title,genre,releaseYear,new ArrayList<>());
        if(id!=null){
            newSong.setId(id);
            newSong.setPerformers(songRepository.findById(id).orElseThrow().getPerformers());
        }
        Album albumToAdd = albumRepository.findById(albumId).orElseThrow();
        newSong.setAlbum(albumToAdd);
        songRepository.save(newSong);
    }

    @Override
    public void removeArtistFromSong(Long songId, Long performerId) {

        songRepository.removePerformerFromSong(songId,performerId);
    }
}
