package mk.ukim.finki.lab1b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;


@Data
public class Artist {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;

    public Artist(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        Random random = new Random();
        id = random.nextLong(1000);
    }
}
