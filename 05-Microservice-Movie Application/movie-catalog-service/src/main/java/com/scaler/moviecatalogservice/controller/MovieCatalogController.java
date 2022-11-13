package com.scaler.moviecatalogservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.scaler.moviecatalogservice.models.CatalogItem;
import com.scaler.moviecatalogservice.models.Movie;
import com.scaler.moviecatalogservice.models.Rating;
import com.scaler.moviecatalogservice.models.UserRating;
import com.scaler.moviecatalogservice.service.MovieInfoService;
import com.scaler.moviecatalogservice.service.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private  WebClient.Builder webClientBuilder;
    @Autowired
    private MovieInfoService movieInfoService;
    @Autowired
    private MovieRatingService movieRatingService;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String  userId){
        // 1) Get all rated Movie IDs
        var userRating= movieRatingService.getUserRating(userId);

        var response=userRating.getUserRatingList().stream().map(rating->{
            // 2) For all movie ID, call movie-info-service to get movie details
            // 3) put them all together and send it back.
            return movieInfoService.getCatalogItems(rating);
        }).collect(Collectors.toList());
        return response;
    }
}
