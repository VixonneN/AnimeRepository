package com.example.feature_content.states

sealed class ContentEvent {
    data class LoadContent(val typeContent: String, val type: String) : ContentEvent()
}