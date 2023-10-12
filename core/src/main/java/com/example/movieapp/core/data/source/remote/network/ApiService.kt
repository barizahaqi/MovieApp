package com.example.movieapp.core.data.source.remote.network

import com.example.movieapp.core.data.source.remote.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getListMovies(
        @Query("api_key") apiKey: String,
    ): MoviesResponse

}