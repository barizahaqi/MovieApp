package com.example.movieapp.core.data.source.remote

import android.util.Log
import com.example.movieapp.core.data.source.remote.network.ApiResponse
import com.example.movieapp.core.data.source.remote.network.ApiService
import com.example.movieapp.core.data.source.remote.response.MovieItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    private val apiKey = "64f9b1870bb6246e82f67eb2696aaec0"

    suspend fun getListMovies(): Flow<ApiResponse<List<MovieItem>>> {
        return flow {
            try {
                val response = apiService.getListMovies(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}