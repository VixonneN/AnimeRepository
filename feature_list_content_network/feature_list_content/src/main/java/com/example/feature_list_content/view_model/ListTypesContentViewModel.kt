package com.example.feature_list_content.view_model

import com.example.feature_list_content.states.ListTypesContentEvent
import com.example.feature_list_content.states.ListTypesScreenState
import com.example.feature_list_content.states.ListTypesSideEffect
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.khomichenko.core.utils.ContentType
import ru.khomichenko.core.utils.MviViewModel

class ListTypesContentViewModel(

) : MviViewModel<ListTypesScreenState, ListTypesSideEffect, ListTypesContentEvent>(initialState = ListTypesScreenState()) {

    override fun dispatch(event: ListTypesContentEvent) {
        when(event) {
            is ListTypesContentEvent.MoveToSelectedContent -> {  }
            is ListTypesContentEvent.SelectCorrectContentType -> checkContentType(content = event.contentType)
        }
    }

    private fun checkContentType(content: String) {
        intent {
            if(content == ContentType.GIF.type) {
                reduce { state.copy(contentTypeGif = true) }
            } else {
                reduce { state.copy(contentTypePng = true) }
            }
        }
    }
}