package com.areeb.moviesverse.di

import com.areeb.moviesverse.data.ApiConstants.BASE_URL
import com.areeb.moviesverse.data.BaseIntercepter.AppInterceptor
import com.areeb.moviesverse.data.IRemoteOperations
import com.areeb.moviesverse.data.RemoteOprations
import com.areeb.moviesverse.data.network.remote.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesAppInterceptor(): AppInterceptor {
        return AppInterceptor()
    }

    @Provides
    @Singleton
    fun providesHttpProfiler(appInterceptor: AppInterceptor): OkHttpClient {
        val build = OkHttpClient.Builder().addInterceptor(appInterceptor).build()
        return build
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun providesMoviesApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRemoteOperation(movieApi: MovieApi): IRemoteOperations {
        return RemoteOprations(movieApi)
    }
}
