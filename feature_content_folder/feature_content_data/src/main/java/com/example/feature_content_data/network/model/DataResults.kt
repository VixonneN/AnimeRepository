package com.example.feature_content_data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResults(
    @Json(name = "artist_href")
    val artistHref: String,
    @Json(name = "artist_name")
    val artistName: String,
    @Json(name = "source_url")
    val sourceUrl: String,
    @Json(name = "url")
    val url: String,

)
