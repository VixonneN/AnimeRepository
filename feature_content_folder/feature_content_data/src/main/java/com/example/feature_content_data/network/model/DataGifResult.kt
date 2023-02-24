package com.example.feature_content_data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataGifResult(
    @Json(name = "anime_name")
    val animeName: String,
    val url: String
)