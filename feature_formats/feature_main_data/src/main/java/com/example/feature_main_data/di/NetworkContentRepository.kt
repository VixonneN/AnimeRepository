package com.example.feature_main_data.di

import com.example.feature_main_data.network.api.EndpointApi
import com.example.feature_main_data.network.repository.CountContentNetworkRepository
import com.example.feature_main_data.network.repository.CountContentNetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkContentRepository {

    @Singleton
    @Provides
    fun provideContentApi(retrofit: Retrofit) : EndpointApi =
        retrofit.create(EndpointApi::class.java)

    @Singleton
    @Provides
    fun provideContentRepository(api: EndpointApi) : CountContentNetworkRepository =
        CountContentNetworkRepositoryImpl(api)
}