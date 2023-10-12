package com.example.movieapp.core.domain.repository

import com.example.movieapp.core.data.Resource
import com.example.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getListMovies(): Flow<Resource<List<Movie>>>

    fun getListFavoriteMovies(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

}