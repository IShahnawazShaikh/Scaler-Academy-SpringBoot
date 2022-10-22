package com.scaler.moviecatalogservice.controller;

import com.scaler.moviecatalogservice.models.CatalogItem;
import com.scaler.moviecatalogservice.models.Movie;
import com.scaler.moviecatalogservice.models.Rating;
import com.scaler.moviecatalogservice.models.UserRating;
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
    private RestTemplate restTemplate;

    @Autowired
    private  WebClient.Builder webClientBuilder;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        // 1) Get all rated Movie IDs
        var userRating=restTemplate.getForObject("http://localhost:8083/rating/users/foo", UserRating.class);

        var response=userRating.getUserRatingList().stream().map(rating->{
            // 2) For all movie ID, call movie-info-service to get movie details
            var movie=restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(),Movie.class);
            /*
            var movie=webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movie/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
             */

            // 3) put them all together and send it back.
            return  new CatalogItem(movie.getMovieName(),movie.getDescription(),rating.getRating());
        }).collect(Collectors.toList());
        return response;

    }
}
