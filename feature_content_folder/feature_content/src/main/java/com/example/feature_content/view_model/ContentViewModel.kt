package com.example.feature_content.view_model

import androidx.lifecycle.viewModelScope
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState
import com.example.feature_content.states.ContentSideEffect
import com.example.feature_content_data.network.model.DataResults
import com.example.feature_content_data.network.repository.ContentNetworkRepository
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.core.utils.MviViewModel

class ContentViewModel(
    private val contentNetworkRepository: ContentNetworkRepository
): MviViewModel<ContentScreenState, ContentSideEffect, ContentEvent>(
    initialState = ContentScreenState()
) {

    override fun dispatch(event: ContentEvent) {
        when(event) {
            is ContentEvent.LoadContent -> { loadContent(event.type) }
        }
    }

    private fun loadContent(content: String) {
        intent {
            viewModelScope.launch {
                contentNetworkRepository.loadContent(content = content).collect { status ->
                    when (status) {
                        is DataStatus.Loading -> {
                            reduce { state.copy(loading = true) }
                        }
                        is DataStatus.Success -> {
                            reduce {
                                state.copy(
                                    loading = false,
                                    listImagesData = status.data.listResult
                                )
                            }
                        }
                        is DataStatus.Error -> {
                            reduce {
                                state.copy(
                                    loading = false,
                                    errorMessage = status.errorType
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun loadContent(listData: List<DataResults>) {
        val content = ContentSideEffect.ShowContent(listData)
        intent {  }
    }
}