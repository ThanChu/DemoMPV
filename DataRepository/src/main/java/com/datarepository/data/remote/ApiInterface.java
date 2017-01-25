package com.datarepository.data.remote;

import com.datarepository.model.Movie;
import com.datarepository.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ThangNTX on 12/1/2016.
 */

public interface ApiInterface {
    @GET("movie/popular")
    Call<MoviesResponse> getMovies(@Query("api_key") String apiKey);

    @GET("movie/{movieId}")
    Call<Movie> getMovie(@Query("movieId") String movieId);
}
