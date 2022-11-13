package com.scaler.moviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scaler.moviecatalogservice.models.CatalogItem;
import com.scaler.moviecatalogservice.models.Movie;
import com.scaler.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "getFallbackCatalogItems",
     commandProperties ={
             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
             @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "6"),
             @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),
             @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")
     })
    public CatalogItem getCatalogItems(Rating rating) {
        var movie=restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie/"+ rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getMovieName(), movie.getDescription(), rating.getRating());
    }
    public CatalogItem getFallbackCatalogItems(Rating rating) {
        return new CatalogItem("Movie name not found","movie not found-> no description",rating.getRating());
    }
}
