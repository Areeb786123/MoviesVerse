package com.areeb.moviesverse.di

import com.areeb.moviesverse.data.ApiConstants.BASE_URL
import com.areeb.moviesverse.data.IRemoteOperations
import com.areeb.moviesverse.data.RemoteOprations
import com.areeb.moviesverse.data.network.remote.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
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
