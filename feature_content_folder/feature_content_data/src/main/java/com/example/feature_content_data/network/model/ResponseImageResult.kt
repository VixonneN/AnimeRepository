package com.example.feature_content_data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseImageResult(
    @Json(name = "results")
    val listResult: List<DataImagesResults>
)
