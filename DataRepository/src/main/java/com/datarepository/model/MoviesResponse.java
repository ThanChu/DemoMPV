package com.datarepository.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ThangNTX on 12/1/2016.
 */

public class MoviesResponse {

    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
