package com.areeb.moviesverse.ui.utils.strings

interface CommonStrings {

    interface API {
        companion object {
            const val API_KEY =
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlYzNhZjJjYjc0ZmJiZmE1MDBlYzliYzhkYWE1NGZhMSIsInN1YiI6IjY0OGI0Njg0YzNjODkxMDBlYjMxNDM4NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QoDxOMLfPED6DPu2ypHgvza6uiQ0MFsCqU6-wW40PQU"

            const val BASE_IMAGE_LOAD = "https://image.tmdb.org/t/p/w500/"
        }
    }

    interface App {
        companion object {
            const val IMAGE = "image"
        }
    }

    interface Navigations {
        companion object {
            const val SPLASH = "splash"
            const val HOME = "home"
            const val CATEGORY = "category"
            const val SEARCH = "search"
            const val DETAIL = "detail"
        }
    }
}
