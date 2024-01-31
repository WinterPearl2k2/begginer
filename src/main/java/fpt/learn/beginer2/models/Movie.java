package fpt.learn.beginer2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;

import java.util.List;

@Entity
@Table(name = "MOVIE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;

    @ElementCollection
    @CollectionTable(name = "MOVIE_GENRES", joinColumns = @JoinColumn(name = "movie_id"))
    private List<String> genres;

    @ElementCollection
    @CollectionTable(name = "MOVIE_BACKDROPS", joinColumns = @JoinColumn(name = "movie_id"))
    private List<String> backdrops;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviewIds;

    public String toString() {
        return movieId + "\n" +imdbId + "\n" +title + "\n" +releaseDate + "\n" +trailerLink + "\n" +poster+"\n--------------------";
    }
}