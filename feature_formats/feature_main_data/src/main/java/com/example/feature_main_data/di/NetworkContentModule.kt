package com.example.feature_main_data.di

import com.example.feature_main_data.network.api.EndpointApi
import com.example.feature_main_data.network.repository.CountContentNetworkRepository
import com.example.feature_main_data.network.repository.CountContentNetworkRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

object NetworkContentModule {

    val module = module {
        single { provideContentApi(get()) }
        single<CountContentNetworkRepository> { CountContentNetworkRepositoryImpl(get()) }
    }

    private fun provideContentApi(retrofit: Retrofit) : EndpointApi =
        retrofit.create(EndpointApi::class.java)
}