package com.scaler.moviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scaler.moviecatalogservice.models.Rating;
import com.scaler.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class MovieRatingService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
            commandProperties ={
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "6"),
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")
            })
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://MOVIE-RATING-SERVICE/rating/users/"+userId, UserRating.class);
    }
    public UserRating getFallbackUserRating(String userId) {
        UserRating userRating=new UserRating();
        userRating.setUserRatingList(Arrays.asList(new Rating("0",-1)));
        return userRating;
    }
}
