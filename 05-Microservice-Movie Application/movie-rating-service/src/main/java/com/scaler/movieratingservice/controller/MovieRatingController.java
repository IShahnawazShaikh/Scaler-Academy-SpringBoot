package com.scaler.movieratingservice.controller;

import com.scaler.movieratingservice.models.Rating;
import com.scaler.movieratingservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/rating")
public class MovieRatingController {
    @RequestMapping("/{movieId}")
    public Rating getMovieRatingByMovieId(@PathVariable("movieId") String movieId){
        return new Rating("don",10);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRatingList(@PathVariable("userId") String userId){
        var ratingList= Arrays.asList(
                new Rating("1234",4),
                new Rating("5678",5)
        );

        UserRating userRating=new UserRating();
        userRating.setUserRatingList(ratingList);
        return userRating;
    }
}
