package com.areeb.moviesverse.data

import android.util.Log
import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying
import com.areeb.moviesverse.data.network.remote.api.MovieApi
import javax.inject.Inject

class RemoteOprations @Inject constructor(private val movieApi: MovieApi) : IRemoteOperations {
    companion object {
        private const val TAG = "RemoteOperation"
    }
    override suspend fun getAllMovies(): Resource<NowPlaying> {
        return try {
            val response = movieApi.getAllMovies()
            Resource.Success(response)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            Resource.Error(e.message.toString())
        }
    }
}
