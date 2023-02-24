package com.example.feature_content.states

import com.example.feature_content_data.network.model.DataGifResult
import com.example.feature_content_data.network.model.DataImagesResults
import ru.khomichenko.core.utils.ErrorType

data class ContentScreenState(
    val loading: Boolean = false,
    val listImagesData: List<DataImagesResults> = emptyList(),
    val errorMessage: ErrorType = ErrorType.Unknown,
    val listGifsData: List<DataGifResult> = emptyList()
)