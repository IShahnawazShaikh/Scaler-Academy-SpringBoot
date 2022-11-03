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
    public Rating getMovieRatingByMovieId(@PathVariable("movieId") Integer movieId){
        return new Rating(112,10);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRatingList(@PathVariable("userId") String userId){
        var ratingList= Arrays.asList(
                new Rating(112,4),
                new Rating(113,5)
        );

        UserRating userRating=new UserRating();
        userRating.setUserRatingList(ratingList);
        return userRating;
    }
}
