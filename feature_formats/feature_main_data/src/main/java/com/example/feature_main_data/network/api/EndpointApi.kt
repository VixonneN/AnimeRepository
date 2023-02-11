package com.example.feature_main_data.network.api

import com.example.feature_main_data.network.model.EndpointModel
import retrofit2.http.GET

interface EndpointApi {

    @GET("endpoints")
    fun fetchEndPoints() : Map<String, EndpointModel>
}