package com.example.feature_content.view_model

import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState
import com.example.feature_content.states.ContentSideEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.khomichenko.core.utils.MviViewModel
import ru.khomichenko.domain.network.use_case.SleepingGifsUseCase
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val sleepingGifsUseCase: SleepingGifsUseCase
) : MviViewModel<ContentScreenState, ContentSideEffect, ContentEvent>(
    initialState = ContentScreenState()
) {
    override fun dispatch(event: ContentEvent) {
        when(event) {
            ContentEvent.LoadContent -> {  }
        }
    }

    private fun loadContent() {
        intent {
            reduce { state.copy(loading = true) }
            sleepingGifsUseCase()
            reduce { state.copy(loading = false) }
        }
    }
}