package ru.khomichenko.main_data.network.dto.gif

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GifsResponseDto(
    @Json(name = "results")
    val listResult: List<GifValueDto>
)