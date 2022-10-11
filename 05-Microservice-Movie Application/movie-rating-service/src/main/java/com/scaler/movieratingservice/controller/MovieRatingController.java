package com.scaler.movieratingservice.controller;

import com.scaler.movieratingservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class MovieRatingController {
    @RequestMapping("/{movieId}")
    public Rating getMovieRatingByMovieId(@PathVariable("movieId") String movieId){
        return new Rating("don",10);
    }
}
