package com.example.movieapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.core.domain.model.Movie
import com.example.movieapp.databinding.ActivityDetailMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)


        @Suppress("DEPRECATION") val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            binding.apply {
                content.apply {
                    Glide.with(this@DetailMovieActivity)
                        .load("https://image.tmdb.org/t/p/w500" + detailMovie.posterPath)
                        .into(detailImage)
                }
                movieDetailTitle.text = detailMovie.title
                overviewDetail.text = detailMovie.overview
                content.ratingMovie.text = detailMovie.voteAverage.toString()
                "Release Date: ${detailMovie.releaseDate}".also {
                    content.releaseDate.text = it
                }
                "Popularity: ${detailMovie.popularity}".also { content.popularity.text = it }
                "Vote Count: ${detailMovie.voteCount}".also { content.voteCount.text = it }
                var statusFavorite = detailMovie.favorite
                setStatusFavorite(statusFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailMovieViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this, R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this, R.drawable.ic_not_favorite_white
                )
            )
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}