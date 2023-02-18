package com.example.feature_content_data.di

import com.example.feature_content_data.network.api.EndpointApi
import org.koin.dsl.module
import retrofit2.Retrofit

object NetworkContentDataModule {

    val module = module {
        single { provideContentApi(retrofit = get()) }
    }

    private fun provideContentApi(retrofit: Retrofit) : EndpointApi =
        retrofit.create(EndpointApi::class.java)
}