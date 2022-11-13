package com.scaler.moviecatalogservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    public List<CatalogItem> getCatalog(@PathVariable("userId") String  userId){
        // 1) Get all rated Movie IDs
        var userRating= getUserRating(userId);

        var response=userRating.getUserRatingList().stream().map(rating->{
            // 2) For all movie ID, call movie-info-service to get movie details
            // 3) put them all together and send it back.
            return getCatalogItems(rating);
        }).collect(Collectors.toList());
        return response;

    }
    @HystrixCommand(fallbackMethod = "getFallbackCatalogItems")
    private CatalogItem getCatalogItems(Rating rating) {
        var movie=restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie/"+ rating.getMovieId(),Movie.class);
        return new CatalogItem(movie.getMovieName(), movie.getDescription(), rating.getRating());
    }
    private CatalogItem getFallbackCatalogItems(Rating rating) {
        return new CatalogItem("Movie name not found","movie not found-> no description",rating.getRating());
    }

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    private UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://MOVIE-RATING-SERVICE/rating/users/"+userId, UserRating.class);
    }
    private UserRating getFallbackUserRating(String userId) {
        UserRating userRating=new UserRating();
        userRating.setUserRatingList(Arrays.asList(new Rating("0",0)));
        return userRating;
    }
    public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String  userId) {
       var response=Arrays.asList(new CatalogItem("no movie","response from fallback method",-1));
       return response;
    }
}
