package com.scaler.moviecatalogservice.models;

public class CatalogItem {
    private String movieName;
    private String movieDescription;


    public CatalogItem(String movieName, String movieDescription, Integer rating) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.rating = rating;
    }

    private Integer rating;


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
