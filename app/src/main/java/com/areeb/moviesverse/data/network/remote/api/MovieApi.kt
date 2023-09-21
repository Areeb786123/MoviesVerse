package com.areeb.moviesverse.data.network.remote.api

import com.areeb.moviesverse.data.ApiConstants.UP_COMING
import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying
import retrofit2.http.GET

interface MovieApi {
    @GET(UP_COMING)
    suspend fun getAllMovies(): NowPlaying
}
