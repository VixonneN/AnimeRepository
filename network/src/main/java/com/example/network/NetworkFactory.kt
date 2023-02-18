package com.example.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import ru.khomichenko.network.BuildConfig

class NetworkFactory {

    fun createRetrofit(
        okHttpClient: OkHttpClient,
        api: String
    ) : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(api)
        .build()

    fun createOkHttp() : OkHttpClient {
        val builder = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .readTimeout(timeout = 15000L, unit = TimeUnit.MILLISECONDS)
            .connectTimeout(timeout = 10000L, unit = TimeUnit.MILLISECONDS)
            .writeTimeout(timeout = 10000L, unit = TimeUnit.MILLISECONDS)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return builder.build()
    }
}