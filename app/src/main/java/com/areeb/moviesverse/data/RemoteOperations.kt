package com.areeb.moviesverse.data

import android.util.Log
import com.areeb.moviesverse.data.models.request.nowPlaying.Movies
import com.areeb.moviesverse.data.network.remote.api.MovieApi
import javax.inject.Inject

class RemoteOperations @Inject constructor(private val movieApi: MovieApi) : IRemoteOperations {
    companion object {
        private const val TAG = "RemoteOperation"
    }

    override suspend fun getAllMovies(): Resource<Movies> {
        return try {
            val response = movieApi.getAllMovies()
            Resource.Success(response)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun getMovieByCategories(cate: String): Resource<Movies> {
        return try {
            val response = movieApi.getMovieByCategories(cate)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
}
