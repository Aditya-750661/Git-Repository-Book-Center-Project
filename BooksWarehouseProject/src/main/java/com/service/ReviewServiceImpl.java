package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Book;
import com.model.Review;
import com.model.User;
import com.dao.*;
import com.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private BookRepository bookRepo;
    
    @Override
    public Review createReview(long id ,Review review) 
    {
    
    	System.out.println(review);
    	User user = userRepo.findById(id).orElse(null);
		Book book = bookRepo.findById(review.getBook().getBookId()).orElse(null);
    	
		if (user == null) {
			System.out.println("user null");
			throw new IllegalArgumentException("User not found");
		}
		if (book == null) {
			System.out.println("user null");
			throw new IllegalArgumentException("Book not found");
		}

		review.setUser(user);
		review.setBook(book);
		
		return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        return optionalReview.orElse(null);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Optional<Review> optionalExistingReview = reviewRepository.findById(id);
        if (optionalExistingReview.isPresent()) {
            Review existingReview = optionalExistingReview.get();

            existingReview.setRating(review.getRating());
            existingReview.setComment(review.getComment());

           
            return reviewRepository.save(existingReview);
        }
        return null;
    }


    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
