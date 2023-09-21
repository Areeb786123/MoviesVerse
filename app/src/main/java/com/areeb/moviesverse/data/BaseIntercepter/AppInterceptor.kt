package com.areeb.moviesverse.data.BaseIntercepter

import com.areeb.moviesverse.data.ApiConstants.ACCEPT_HEADERS
import com.areeb.moviesverse.ui.utils.strings.CommonStrings.API.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AppInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().addHeader("accept", ACCEPT_HEADERS)
            .addHeader("Authorization", API_KEY)
        return chain.proceed(builder.build())
    }
}
