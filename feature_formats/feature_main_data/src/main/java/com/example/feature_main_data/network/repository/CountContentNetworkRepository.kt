package com.example.feature_main_data.network.repository

import com.example.feature_main_data.network.model.EndpointModel
import kotlinx.coroutines.flow.Flow
import ru.khomichenko.core.utils.DataStatus

interface CountContentNetworkRepository {

    fun fetchCountContent() : Flow<DataStatus<Map<String, EndpointModel>>>
}