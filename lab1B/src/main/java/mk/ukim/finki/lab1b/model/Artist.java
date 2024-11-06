package mk.ukim.finki.lab1b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Artist {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
}
