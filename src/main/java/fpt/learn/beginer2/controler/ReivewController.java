package fpt.learn.beginer2.controler;

import fpt.learn.beginer2.models.Movie;
import fpt.learn.beginer2.models.Review;
import fpt.learn.beginer2.repository.MovieRepository;
import fpt.learn.beginer2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class ReivewController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    MovieRepository movieRepository;

    @PostMapping("{movieId}/review")
    public ResponseEntity<Review> createReview(@PathVariable long movieId, @RequestBody Review review) {
        try {
            Movie movie = movieRepository.findById(movieId).orElse(null);
            if(movie != null) {
                review.setMovie(movie);
                movie.getReviewIds().add(review);
                reviewService.createReview(review);
                return new ResponseEntity<>(review, HttpStatus.CREATED);
            } else {
                System.out.println("not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
