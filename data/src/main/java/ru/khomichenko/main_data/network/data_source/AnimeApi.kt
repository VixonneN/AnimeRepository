package ru.khomichenko.main_data.network.data_source

import retrofit2.Response
import retrofit2.http.GET
import ru.khomichenko.main_data.network.dto.gif.GifsResponseDto

interface AnimeApi {

    @GET("sleep")
    suspend fun sleepingGifs() : GifsResponseDto
}