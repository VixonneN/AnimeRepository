package com.example.feature_content.states

import com.example.feature_content_data.network.model.DataResults
import ru.khomichenko.core.utils.ErrorType

data class ContentScreenState(
    val loading: Boolean = false,
    val listImagesData: List<DataResults> = emptyList(),
    val errorMessage: ErrorType = ErrorType.Unknown,
)