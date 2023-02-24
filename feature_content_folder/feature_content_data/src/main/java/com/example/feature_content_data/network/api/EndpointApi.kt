package com.example.feature_content_data.network.api

import com.example.feature_content_data.network.model.ResponseGifResult
import com.example.feature_content_data.network.model.ResponseImageResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndpointApi {

    //todo разобраться как формируется ссылка
    @GET("/api/v2/{content}")
    suspend fun getContentSource(
        @Path("content") content: String,
        @Query("amount") amount: Int = standardAmount
    ) : ResponseImageResult

    @GET("/api/v2/{content}")
    suspend fun getGifContent(
        @Path("content") content: String,
        @Query("amount") amount: Int = standardAmount
    ) : ResponseGifResult

    private companion object {
        const val standardAmount = 20
    }
}