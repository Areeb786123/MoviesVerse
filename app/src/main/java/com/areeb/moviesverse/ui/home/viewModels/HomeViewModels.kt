package com.areeb.moviesverse.ui.home.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.moviesverse.data.Resource
import com.areeb.moviesverse.data.models.request.nowPlaying.Movies
import com.areeb.moviesverse.data.models.request.nowPlaying.Result
import com.areeb.moviesverse.data.repository.NowPlayingRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModels @Inject constructor(private val nowPlayingRepo: NowPlayingRepo) : ViewModel() {

    private val _nowPlaying = MutableStateFlow<List<Result>>(emptyList())
    val nowPlaying: StateFlow<List<Result>> get() = _nowPlaying

    private val _moviesByCategories = MutableStateFlow<List<Movies>>(emptyList())
    val moviesByCategory: StateFlow<List<Movies>> get() = _moviesByCategories

    private val _filterIndex = MutableStateFlow<Int>(0)
    val filterIndex: StateFlow<Int> = _filterIndex

    companion object {
        private const val TAG = "HomeViewModels"
    }

    fun setMutableStateFlow(index: Int) {
        _filterIndex.value = index
    }

    init {
        getNowPlaying()
    }

    fun getNowPlaying(filteration: Int = 0) {
        viewModelScope.launch {
            nowPlayingRepo.getAllNowPlayingMovies().collectLatest {
                getNowPlayingResponse(it, filteration)
            }
        }
    }

    fun getMoviesByCategories() {
        viewModelScope.launch {
            // refactor it for action and other stuff check from moviesDB api
            nowPlayingRepo.getMoviesByCategories("drama".lowercase())
                .collectLatest {
                    Log.e("areebxx", it.toString())
                }
        }
    }

    private fun getNowPlayingResponse(resource: Resource<Movies>, filteration: Int) {
        when (resource) {
            is Resource.Success -> {
                _nowPlaying.value = sortData(resource.data.results, filteration)
            }

            is Resource.Error -> {
                Log.e(TAG, resource.errorMessage)
            }

            else -> {
                Log.e(TAG, "some error occur")
            }
        }
    }

    private fun sortData(results: List<Result>, filteration: Int): List<Result> {
        var result: List<Result>
        when (filteration) {
            0 -> {
                result = results.sortedByDescending { it.vote_average }
            }

            1 -> {
                result = results.sortedByDescending { it.release_date }
            }

            else -> {
                result = results.sortedByDescending { it.popularity }
            }
        }

        return result
    }
}
