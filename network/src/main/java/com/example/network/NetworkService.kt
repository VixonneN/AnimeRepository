package com.example.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

class NetworkService(
    private val networkFactory: NetworkFactory
) {
    private val baseUrl = "https://nekos.best/api/v2/"

    private val okHttpClient : OkHttpClient by lazy {
        networkFactory.createOkHttp()
    }

    val serviceRetrofit: Retrofit by lazy {
        networkFactory.createRetrofit(
            okHttpClient = okHttpClient,
            api = baseUrl
        )
    }
}