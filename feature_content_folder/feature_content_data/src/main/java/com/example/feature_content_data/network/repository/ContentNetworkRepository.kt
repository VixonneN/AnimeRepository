package com.example.feature_content_data.network.repository

import com.example.feature_content_data.network.model.ResponseGifResult
import com.example.feature_content_data.network.model.ResponseImageResult
import kotlinx.coroutines.flow.Flow
import ru.khomichenko.core.utils.DataStatus

interface ContentNetworkRepository {
    fun loadImageContent(content: String) : Flow<DataStatus<ResponseImageResult>>
    fun loadGifContent(content: String) : Flow<DataStatus<ResponseGifResult>>
}