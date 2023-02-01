package ru.khomichenko.animerepository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.khomichenko.domain.network.repository.AnimeNetworkRepository
import ru.khomichenko.main_data.network.data_source.AnimeApi
import ru.khomichenko.main_data.network.repository.AnimeNetworkRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNetworkRepository(networkApi: AnimeApi) : AnimeNetworkRepository =
        AnimeNetworkRepositoryImpl(networkApi)

}