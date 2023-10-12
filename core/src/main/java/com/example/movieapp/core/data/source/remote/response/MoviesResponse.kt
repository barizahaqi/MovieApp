package com.example.movieapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<MovieItem>,

    @field:SerializedName("total_results")
    val totalResults: Int
)


