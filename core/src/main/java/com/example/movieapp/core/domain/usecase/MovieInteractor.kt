package com.example.movieapp.core.domain.usecase

import com.example.movieapp.core.domain.model.Movie
import com.example.movieapp.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getListMovies() = movieRepository.getListMovies()

    override fun getListFavoriteMovies() = movieRepository.getListFavoriteMovies()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)

}