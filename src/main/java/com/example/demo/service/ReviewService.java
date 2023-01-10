package com.example.demo.service;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.Product;
import com.example.demo.model.Review;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void createReview(Integer productId, ReviewDTO reviewDTO) throws Exception {
        productRepository.findById(productId).map(product -> {
            Review tmpReview = Review.builder()
                    .username(reviewDTO.getUsername())
                    .shortDescription(reviewDTO.getShortDescription())
                    .rating(reviewDTO.getRating())
                    .product(product)
                    .build();
            return reviewRepository.save(tmpReview);
        }).orElseThrow(() -> new Exception("Not found product by id"));
    }

}
