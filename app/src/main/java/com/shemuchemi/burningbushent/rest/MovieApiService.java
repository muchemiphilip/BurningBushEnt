package com.shemuchemi.burningbushent.rest;

import com.shemuchemi.burningbushent.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("discover/movie")
    Call<MovieResponse> getDiscoverMovies(@Query("api_key") String apiKey);
}
