package com.example.moviedemo2.Infra;

import com.example.moviedemo2.model.MovieDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {

    @GET("movie/now_playing")
    Call<MovieDBResponse> getPlayingMovies(@Query("api_key") String api_Key);
}
