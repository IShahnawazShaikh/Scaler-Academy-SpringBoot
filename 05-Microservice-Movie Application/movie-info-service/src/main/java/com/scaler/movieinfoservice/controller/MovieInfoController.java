package com.scaler.movieinfoservice.controller;

import com.scaler.movieinfoservice.models.Movie;
import com.scaler.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/movie")
public class MovieInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;
    @RequestMapping("/{movieId}")
    public Movie getMovieDetails(@PathVariable("movieId") String movieId){
         var movieSummary=restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieSummary.class);
         return new Movie(movieSummary.getTitle(),movieSummary.getId(),movieSummary.getOverview());
    }
}
