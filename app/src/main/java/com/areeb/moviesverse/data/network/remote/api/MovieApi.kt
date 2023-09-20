package com.areeb.moviesverse.data.network.remote.api

import com.areeb.moviesverse.data.ApiConstants.ACCEPT_HEADERS
import com.areeb.moviesverse.data.ApiConstants.NOW_PLAYING
import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.API.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Header

interface MovieApi {
    @GET(NOW_PLAYING)
    suspend fun getAllMovies(
        @Header("accept") acceptHeader: String = ACCEPT_HEADERS,
        @Header("Authorization") authorizationHeader: String = API_KEY,
    ): NowPlaying
}
