package mk.ukim.finki.lab1b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;


@AllArgsConstructor
@Data
public class Album {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    public Album(String name, String genre, String releaseYear) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        Random random = new Random();
        id = random.nextLong(1000);
//        System.out.print(name + " " + id);
    }
}
