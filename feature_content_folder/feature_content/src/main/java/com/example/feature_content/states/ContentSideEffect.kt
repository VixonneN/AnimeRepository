package com.example.feature_content.states

import com.example.feature_content_data.network.model.DataResults

sealed class ContentSideEffect {
    data class LoadAnimeContent(val content: String) : ContentSideEffect()
    class ShowContent(val content: List<DataResults>)
}