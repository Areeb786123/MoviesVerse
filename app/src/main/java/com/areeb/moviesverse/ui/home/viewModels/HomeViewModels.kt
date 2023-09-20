package com.areeb.moviesverse.ui.home.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.moviesverse.data.RemoteOprations
import com.areeb.moviesverse.data.models.request.nowPlaying.NowPlaying
import com.areeb.moviesverse.data.repository.NowPlayingRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModels @Inject constructor(val nowPlayingRepo: NowPlayingRepo) : ViewModel() {

    init {
        getNowPlaying()
    }

    fun getNowPlaying() {
        viewModelScope.launch {
            nowPlayingRepo.getAllNowPlayingMovies()
        }
    }
}
