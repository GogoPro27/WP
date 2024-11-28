package mk.ukim.finki.lab1b.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1b.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ArtistRepository {
    private final List<Artist> artists;

    public ArtistRepository() {
        artists = new ArrayList<>();
        artists.add(new Artist( "Freddie", "Mercury", "British singer, songwriter, and lead vocalist of the rock band Queen."));
        artists.add(new Artist( "Whitney", "Houston", "American singer and actress, known as 'The Voice' and one of the best-selling music artists of all time."));
        artists.add(new Artist("Elvis", "Presley", "American singer, known as the 'King of Rock and Roll'."));
        artists.add(new Artist( "Aretha", "Franklin", "American singer, songwriter, and pianist, known as the 'Queen of Soul'."));
        artists.add(new Artist( "Michael", "Jackson", "American singer, songwriter, and dancer, known as the 'King of Pop'."));
        artists.forEach(a->{
            System.out.printf("%d %s%n",a.getId(),a.getFirstName());
        });
    }
    public List<Artist> findAll(){
        return artists;
    }
    public Optional<Artist> findById(Long id){
        return artists.stream()
                .filter(a->a.getId().equals(id))
                .findFirst();
    }
}
