package com.scaler.movieinfoservice.models;

public class Movie {
    private String movieName;
    private Integer movieId;
    private String description;

    public Movie(){}
    public Movie(String movieName, Integer movieId, String description) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.description = description;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
