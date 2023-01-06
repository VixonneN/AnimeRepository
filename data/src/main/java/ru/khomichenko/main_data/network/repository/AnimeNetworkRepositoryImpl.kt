package ru.khomichenko.main_data.network.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.core.utils.getErrorType
import ru.khomichenko.core.utils.toDataStatus
import ru.khomichenko.core.utils.toHttpError
import ru.khomichenko.domain.network.entity.GifsResponseEntity
import ru.khomichenko.domain.network.repository.AnimeNetworkRepository
import ru.khomichenko.main_data.network.data_source.AnimeApi
import ru.khomichenko.main_data.network.mapper.toEntity
import javax.inject.Inject

class AnimeNetworkRepositoryImpl @Inject constructor(
    private val animeApi: AnimeApi
) : AnimeNetworkRepository{

    override suspend fun getSleepingGifs(): DataStatus<GifsResponseEntity> =
        withContext(Dispatchers.IO) {
            try {
                val data = animeApi.sleepingGifs().toEntity()
                DataStatus.Success(data)
            } catch (e: HttpException) {
                DataStatus.Error(e.code().toHttpError())
            } catch (e: IOException) {
                DataStatus.Error(e.getErrorType())
            }
        }

}