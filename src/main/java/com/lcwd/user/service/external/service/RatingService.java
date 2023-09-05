package com.lcwd.user.service.external.service;

import com.lcwd.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {


    //this methods are declarative approach

    //get method
    @GetMapping("/api/user/{userId}")
    Rating getRating(@PathVariable String userId);

    //Post method
    @PostMapping("/api/create")
    //if there is no userdefined means  not there means we have to do create this method
    //public Rating createRating(Map<String,Objects> values);

    //but we are having the rating Values so this method`
    public Rating createRating(Rating values);
    //public ResponseEntity<Rating> updateRating( Rating rating);

    //let test

    //crete the update
    @PutMapping("/ratings/{ratingId}")

    public Rating updateRating( @PathVariable String ratingId,   Rating rating);
//    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating rating);
    //deleting the given rating using the rating Id

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);



}

