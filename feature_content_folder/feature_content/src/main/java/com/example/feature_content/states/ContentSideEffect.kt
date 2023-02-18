package com.example.feature_content.states

sealed class ContentSideEffect {
    data class LoadAnimeContent(val content: String) : ContentSideEffect()
}