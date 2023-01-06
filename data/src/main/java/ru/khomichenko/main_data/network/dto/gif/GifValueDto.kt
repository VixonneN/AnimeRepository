package ru.khomichenko.main_data.network.dto.gif

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GifValueDto(
    @Json(name = "anime_name")
    val animeName: String,
    @Json(name = "url")
    val url: String
)
