package com.areeb.moviesverse.data

import com.areeb.moviesverse.data.models.request.nowPlaying.Movies

interface IRemoteOperations {
    suspend fun getAllMovies(): Resource<Movies>
    suspend fun getMovieByCategories(cate: String): Resource<Movies>
}
