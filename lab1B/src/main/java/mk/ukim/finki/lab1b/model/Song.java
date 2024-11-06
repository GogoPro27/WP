package mk.ukim.finki.lab1b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;

}
