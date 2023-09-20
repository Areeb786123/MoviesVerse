package com.areeb.moviesverse.data.repository

import android.util.Log
import com.areeb.moviesverse.data.RemoteOprations
import javax.inject.Inject

class NowPlayingRepo @Inject constructor(val remoteOperations: RemoteOprations) {

    companion object {
        private const val TAG = "NowPlayingRepo"
    }
    suspend fun getAllNowPlayingMovies() {
        try {
            Log.e(TAG, remoteOperations.getAllMovies().toString())
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }
}
