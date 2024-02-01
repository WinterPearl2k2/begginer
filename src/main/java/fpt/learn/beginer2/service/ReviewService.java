package fpt.learn.beginer2.service;

import fpt.learn.beginer2.models.Movie;
import fpt.learn.beginer2.models.Review;
import fpt.learn.beginer2.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
}
