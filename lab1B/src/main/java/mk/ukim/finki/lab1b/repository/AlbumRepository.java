package mk.ukim.finki.lab1b.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1b.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    private final List<Album> albums;

    public AlbumRepository() {
        Album album1 = new Album("Abbey Road", "Rock", "1969");
        Album album2 = new Album("Thriller", "Pop", "1982");
        Album album3 = new Album("Kind of Blue", "Jazz", "1959");
        Album album4 = new Album("The Dark Side of the Moon", "Progressive Rock", "1973");
        Album album5 = new Album("Back in Black", "Hard Rock", "1980");
        albums = Arrays.asList(album1, album2, album3, album4, album5);
    }

    public List<Album> findAll(){
        return albums;
    }
    public Optional<Album> findById(Long id){
        return albums.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
