package fpt.learn.beginer2.service;

import fpt.learn.beginer2.models.Movie;
import fpt.learn.beginer2.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public List<Movie> getAllMovie(@RequestParam(required = false) String movieName) {
        if(movieName == null) {
            return movieRepository.findAll();
        } else {
            return movieRepository.getMovieByTitle(movieName);
        }
    }

    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
    public Movie singleMovie(@PathVariable long id) {
        return movieRepository.getMovieByMovieId(id);
    }
}
