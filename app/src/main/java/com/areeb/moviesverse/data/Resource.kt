package com.areeb.moviesverse.data

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error<out T>(val errorMessage: String) : Resource<Nothing>()
    data class Loading<out T>(val isLoading: Boolean? = null) : Resource<Nothing>()
}
