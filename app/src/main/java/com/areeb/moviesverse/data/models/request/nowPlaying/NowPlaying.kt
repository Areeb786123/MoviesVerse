package com.areeb.moviesverse.data.models.request.nowPlaying

import com.google.gson.annotations.SerializedName

data class NowPlaying(
    val dates: Dates,
    val page: Int,
    val results: List<Result> = emptyList(),
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
)
