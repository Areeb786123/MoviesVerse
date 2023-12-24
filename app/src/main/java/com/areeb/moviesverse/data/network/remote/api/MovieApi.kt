package com.areeb.moviesverse.data.network.remote.api

import com.areeb.moviesverse.data.ApiConstants.UP_COMING
import com.areeb.moviesverse.data.models.request.nowPlaying.Movies
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET(UP_COMING)
    suspend fun getAllMovies(): Movies

    @GET("{query}")
    suspend fun getMovieByCategories(@Path("query") type: String): Movies
}
