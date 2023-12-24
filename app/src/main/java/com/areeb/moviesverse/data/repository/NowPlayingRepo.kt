package com.areeb.moviesverse.data.repository

import android.util.Log
import com.areeb.moviesverse.data.RemoteOperations
import com.areeb.moviesverse.data.Resource
import com.areeb.moviesverse.data.models.request.nowPlaying.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NowPlayingRepo @Inject constructor(val remoteOperations: RemoteOperations) {

    companion object {
        private const val TAG = "NowPlayingRepo"
    }

    fun getAllNowPlayingMovies(): Flow<Resource<Movies>> {
        return flow {
            try {
                val response = remoteOperations.getAllMovies()
                emit(response)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getMoviesByCategories(cate: String): Flow<Resource<Movies>> {
        return flow {
            try {
                val response = remoteOperations.getMovieByCategories(cate)
                emit(response)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }
}
