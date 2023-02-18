package com.example.feature_content.view_model

import androidx.lifecycle.viewModelScope
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState
import com.example.feature_content.states.ContentSideEffect
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.khomichenko.core.utils.MviViewModel

class ContentViewModel: MviViewModel<ContentScreenState, ContentSideEffect, ContentEvent>(
    initialState = ContentScreenState()
) {
    override fun dispatch(event: ContentEvent) {
        when(event) {
            is ContentEvent.LoadContent -> { loadContent() }
        }
    }

    private fun loadContent() {
        intent {
            viewModelScope.launch {
                reduce { state.copy(loading = true) }
                delay(2000)
                reduce { state.copy(loading = false) }
            }
        }
    }
}