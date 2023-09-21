package com.areeb.moviesverse.data.network.remote.api

import com.areeb.moviesverse.data.ApiConstants.NOW_PLAYING
import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying
import retrofit2.http.GET

interface MovieApi {
    @GET(NOW_PLAYING)
    suspend fun getAllMovies(): NowPlaying
}
