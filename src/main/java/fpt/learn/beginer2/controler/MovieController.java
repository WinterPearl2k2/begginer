package fpt.learn.beginer2.controler;

import fpt.learn.beginer2.models.Movie;
import fpt.learn.beginer2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/movies")
public class MovieController{
    @Autowired
    MovieRepository movieRepository;

    @GetMapping(path = "/all_movies")
    public ResponseEntity<List<Movie>> getAllMovie(@RequestParam(required = false) String movieName) {
        try {
            List<Movie> movieList = new ArrayList<>();
            movieRepository.findAll().forEach(movie -> System.out.println(movie.toString()));
            if(movieName == null) {
                movieList.addAll(movieRepository.findAll());
            } else {
                movieList.addAll(movieRepository.getMovieByTitle(movieName));
            }
            if (movieList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(path = "/add_movie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            movieRepository.save(movie);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
