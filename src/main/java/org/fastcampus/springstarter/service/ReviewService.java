package org.fastcampus.springstarter.service;

import org.fastcampus.springstarter.entity.Review;
import org.fastcampus.springstarter.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review save(Review review){
        return reviewRepository.save(review);
    }
    public Double reviewAvgRating(Long book_id){
         return  reviewRepository.findAverageRatingByBookId(book_id);
    }

    @Transactional
    public void deleteReviewById(Long review_id){
        reviewRepository.deleteById(review_id); // delete SQL~
    }
}
