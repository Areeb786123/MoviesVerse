package com.areeb.moviesverse.data

import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying

interface IRemoteOperations {
    suspend fun getAllMovies(): Resource<NowPlaying>
}
