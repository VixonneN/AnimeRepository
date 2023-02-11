package com.example.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import ru.khomichenko.network.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object NetworkInitializationModule {

    private const val BASE_URL = "https://nekos.best/api/v2/"

    @Singleton
    @Provides
    fun provideNetwork(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient =
        if(BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .readTimeout(timeout = 15000L, unit = TimeUnit.MILLISECONDS)
                .connectTimeout(timeout = 10000L, unit = TimeUnit.MILLISECONDS)
                .writeTimeout(timeout = 10000L, unit = TimeUnit.MILLISECONDS)
                .build()
        } else {
            OkHttpClient.Builder()
                .readTimeout(timeout = 15000L, unit = TimeUnit.MILLISECONDS)
                .connectTimeout(timeout = 10000L, unit = TimeUnit.MILLISECONDS)
                .writeTimeout(timeout = 10000L, unit = TimeUnit.MILLISECONDS)
                .build()
        }
}