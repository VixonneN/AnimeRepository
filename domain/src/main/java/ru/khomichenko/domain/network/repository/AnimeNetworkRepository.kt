package ru.khomichenko.domain.network.repository

import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.domain.network.entity.GifsResponseEntity

interface AnimeNetworkRepository {

    suspend fun getSleepingGifs() : DataStatus<GifsResponseEntity>
}