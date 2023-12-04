package com.github.userservice.controller;


import com.github.userservice.models.reviewsDTO.ReviewRequestDTO;
import com.github.userservice.models.reviewsDTO.ReviewResponseDTO;
import com.github.userservice.service.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
public class ReviewController {

    @Autowired
    UserReviewService userReviewService;

    @GetMapping("get-all")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews(@RequestHeader HttpHeaders headers){
        return new ResponseEntity<>(userReviewService.getAllReviews(headers), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> createReview(@RequestHeader HttpHeaders headers, @RequestBody ReviewRequestDTO analiseUser){
        return new ResponseEntity<>(userReviewService.createReview(headers, analiseUser), HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<?> createReview(@RequestHeader HttpHeaders headers, @RequestParam String id, @RequestBody ReviewRequestDTO analiseUser){
        return new ResponseEntity<>(userReviewService.updateReview(headers, id, analiseUser), HttpStatus.OK);
    }


}
