package ru.khomichenko.feature_main.main.view_model

import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import ru.khomichenko.core.utils.ContentType
import ru.khomichenko.core.utils.MviViewModel
import ru.khomichenko.domain.network.use_case.SleepingGifsUseCase
import ru.khomichenko.feature_main.main.states.MainScreenEvent
import ru.khomichenko.feature_main.main.states.MainScreenSideEffect
import ru.khomichenko.feature_main.main.states.MainScreenState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sleepUseCase: SleepingGifsUseCase
) : MviViewModel<MainScreenState, MainScreenSideEffect, MainScreenEvent>(initialState = MainScreenState()) {

    override fun dispatch(event: MainScreenEvent) {
        when(event) {
            MainScreenEvent.OnGifsClick -> {
                //some event
                onGifClick()
            }
            MainScreenEvent.OnImagesClick -> {
                onPicturesClick()
            }
        }
    }

    private fun onGifClick() {
        intent {
            postSideEffect(MainScreenSideEffect.NavigateToGifScreen(contentType = ContentType.GIF.type))
        }
    }

    private fun onPicturesClick() {
        intent {
            postSideEffect(MainScreenSideEffect.NavigateToImageScreen(contentType = ContentType.PNG.type))
        }
    }

}