package com.example.feature_list_content.states

//events on screen, like press the buttons
sealed class ListTypesContentEvent {
    data class MoveToSelectedContent(val contentType: String, val type: String): ListTypesContentEvent()
    data class SelectCorrectContentType(val contentType: String): ListTypesContentEvent()
}
