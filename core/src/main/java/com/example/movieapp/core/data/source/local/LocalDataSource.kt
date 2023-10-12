package com.example.movieapp.core.data.source.local

import com.example.movieapp.core.data.source.local.entity.MovieEntity
import com.example.movieapp.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getListMovies(): Flow<List<MovieEntity>> = movieDao.getListMovies()
    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovies()
    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovies(movieList)
    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}