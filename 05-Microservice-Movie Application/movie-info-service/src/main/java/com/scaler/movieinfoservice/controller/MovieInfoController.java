package com.scaler.movieinfoservice.controller;

import com.scaler.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/movie")
public class MovieInfoController {
    @RequestMapping("/{movieId}")
    public Movie getMovieDetails(@PathVariable("movieId") String movieId){
         return new Movie("Don","don","Shahrukh Khan");
    }
}
