package com.example.feature_content.states

import com.example.feature_content_data.network.model.DataImagesResults

sealed class ContentEvent {
    data class LoadContent(val typeContent: String, val type: String) : ContentEvent()
    data class ShowContent(val content: List<DataImagesResults>)
}