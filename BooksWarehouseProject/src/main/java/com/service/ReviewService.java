package com.service;

import java.util.List;

import com.model.Review;

public interface ReviewService {

	void deleteReview(Long id);

	List<Review> getAllReviews();

	Review updateReview(Long id, Review review);

	Review getReviewById(Long id);

	Review createReview(long id ,Review review);

}
