package com.scaler.moviecatalogservice.controller;

import com.scaler.moviecatalogservice.models.CatalogItem;
import com.scaler.moviecatalogservice.models.Movie;
import com.scaler.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        /***
         *  Steps
         *  1) Get all rated Movie IDs
         *  2) For all movie ID, call movie-info-service to get movie details
         *  3) put them all together and send it back.
         */
        var ratingList=Arrays.asList(
                new Rating("1234",4),
                new Rating("5678",5)
        );
        var response=ratingList.stream().map(rating->{
           var movie=restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(),Movie.class);
           return  new CatalogItem(movie.getMovieName(),movie.getDescription(),rating.getRating());
        }).collect(Collectors.toList());
        return response;

    }
}
