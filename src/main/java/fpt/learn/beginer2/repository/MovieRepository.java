package fpt.learn.beginer2.repository;

import fpt.learn.beginer2.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> getMovieByTitle(String title);
}
