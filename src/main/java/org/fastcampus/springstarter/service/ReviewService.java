package org.fastcampus.springstarter.service;

import org.fastcampus.springstarter.entity.Review;
import org.fastcampus.springstarter.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review save(Review review){
        return reviewRepository.save(review);
    }
}
