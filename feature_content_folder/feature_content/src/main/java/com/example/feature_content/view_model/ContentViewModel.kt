package com.example.feature_content.view_model

import androidx.lifecycle.viewModelScope
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState
import com.example.feature_content.states.ContentSideEffect
import com.example.feature_content_data.network.model.DataImagesResults
import com.example.feature_content_data.network.repository.ContentNetworkRepository
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.khomichenko.core.utils.ContentType
import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.core.utils.MviViewModel

class ContentViewModel(
    private val contentNetworkRepository: ContentNetworkRepository
) : MviViewModel<ContentScreenState, ContentSideEffect, ContentEvent>(
    initialState = ContentScreenState()
) {

    //todo change orientation
//    init {
//        dispatch(ContentEvent.LoadContent(value1 = someValue, value2 = someValue))
//    }

    override fun dispatch(event: ContentEvent) {
        when (event) {
            is ContentEvent.LoadContent -> {
                loadContent(content = event.type, contentType = event.typeContent)
            }
        }
    }

    private fun loadContent(content: String, contentType: String) {
        when (contentType) {
            ContentType.PNG.type -> loadImageContent(nameContent = content)
            ContentType.GIF.type -> loadGifContent(nameContent = content)
        }
    }

    private fun loadImageContent(nameContent: String) {
        intent {
            viewModelScope.launch {
                contentNetworkRepository.loadImageContent(content = nameContent).collect { status ->
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
    private fun loadGifContent(nameContent: String) {
        intent {
            viewModelScope.launch {
                contentNetworkRepository.loadGifContent(content = nameContent.filter { !it.isWhitespace() }).collect { status ->
                    when (status) {
                        is DataStatus.Loading -> {
                            reduce { state.copy(loading = true) }
                        }
                        is DataStatus.Success -> {
                            reduce {
                                state.copy(
                                    loading = false,
                                    listGifsData = status.data.listGifResult
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
}