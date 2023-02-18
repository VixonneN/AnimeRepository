package com.example.feature_list_content.states

//events on screen, like press the buttons
sealed class ListTypesContentEvent {
    object MoveToSelectedContent: ListTypesContentEvent()
    data class SelectCorrectContentType(val contentType: String): ListTypesContentEvent()
}
