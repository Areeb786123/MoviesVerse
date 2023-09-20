package com.areeb.moviesverse.data

import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying
import com.areeb.moviesverse.data.network.remote.api.MovieApi
import javax.inject.Inject

class RemoteOprations @Inject constructor(private val movieApi: MovieApi) : IRemoteOperations {
    override suspend fun getAllMovies(): NowPlaying {
        return movieApi.getAllMovies()
    }
}
