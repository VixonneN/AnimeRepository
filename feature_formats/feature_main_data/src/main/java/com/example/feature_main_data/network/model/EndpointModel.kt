package com.example.feature_main_data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EndpointModel(
    val format: String,
    val min: String,
    val max: String
)