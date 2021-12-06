package com.example.movieinfo.di

import com.example.movieinfo.core.Constants
import com.example.movieinfo.data.remote.OmdbApi
import com.example.movieinfo.data.repository.OmdbRepositoryImpl
import com.example.movieinfo.domain.repository.OmdbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesOmdbApi() : OmdbApi{
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OmdbApi::class.java)
    }

    @Provides
    @Singleton
    fun providesOmdbRepository(omdbApi: OmdbApi) : OmdbRepository{
        return OmdbRepositoryImpl(omdbApi)
    }
}