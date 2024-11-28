package mk.ukim.finki.lab1b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Data
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private Long id;
    private Album album;
    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        Random random = new Random();
        id = random.nextLong(1000);
        album = null;
        System.out.printf("Song with id: %d has been generated, song name - %s%n",id,title);
    }
}
