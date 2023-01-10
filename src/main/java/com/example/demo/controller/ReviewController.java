package com.example.demo.controller;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{product_id}")
    public ResponseEntity createReview(@PathVariable("product_id") Integer productId, @RequestBody ReviewDTO reviewDTO) throws Exception {
        reviewService.createReview(productId, reviewDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
