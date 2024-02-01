package fpt.learn.beginer2.controler;

import fpt.learn.beginer2.models.Movie;
import fpt.learn.beginer2.models.Review;
import fpt.learn.beginer2.repository.MovieRepository;
import fpt.learn.beginer2.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/v1/movies")
public class MovieController{
    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/all_movies")
    public ResponseEntity<List<Movie>> getAllMovie(@RequestParam(required = false) String movieName) {
        try {
            List<Movie> movieList = new ArrayList<>();
            movieList.addAll(movieService.getAllMovie(movieName));
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
            movieService.createMovie(movie);
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Movie> singleMovie(@PathVariable("id") long id) {
        try {
            Movie movie = movieService.singleMovie(id);
            System.out.println("call");
            if (movie != null)
                return new ResponseEntity<>(movie, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
