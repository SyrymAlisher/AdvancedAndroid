package com.example.moviemvvm.data.api

import com.example.moviemvvm.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated")
    fun getPopularMovieList(@Query("api_key") apiKey: String): Call<MovieResponse>
}