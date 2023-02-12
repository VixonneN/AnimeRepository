package ru.khomichenko.main_data.di

import org.koin.dsl.module
import retrofit2.Retrofit
import ru.khomichenko.domain.network.repository.AnimeNetworkRepository
import ru.khomichenko.main_data.network.data_source.AnimeApi
import ru.khomichenko.main_data.network.repository.AnimeNetworkRepositoryImpl

object NetworkModule {

    val module = module {
        single { provideNetworkApi(get()) }
        single<AnimeNetworkRepository> { AnimeNetworkRepositoryImpl(get()) }
    }

    private fun provideNetworkApi(retrofit: Retrofit) : AnimeApi =
        retrofit.create(AnimeApi::class.java)

}