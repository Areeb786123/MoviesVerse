package com.areeb.moviesverse.data.repository

import android.util.Log
import com.areeb.moviesverse.data.RemoteOprations
import com.areeb.moviesverse.data.Resource
import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NowPlayingRepo @Inject constructor(val remoteOperations: RemoteOprations) {

    companion object {
        private const val TAG = "NowPlayingRepo"
    }

    suspend fun getAllNowPlayingMovies(): Flow<Resource<NowPlaying>> {
        return flow {
            try {
                val response = remoteOperations.getAllMovies()
                emit(response)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}
