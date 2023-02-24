package ru.khomichenko.feature_main.main.view_model

import com.example.feature_main_data.network.repository.CountContentNetworkRepository
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import ru.khomichenko.core.utils.ContentType
import ru.khomichenko.core.utils.MviViewModel
import ru.khomichenko.feature_main.main.states.MainScreenEvent
import ru.khomichenko.feature_main.main.states.MainScreenSideEffect
import ru.khomichenko.feature_main.main.states.MainScreenState

class MainViewModel(
    private val countContentNetworkRepository: CountContentNetworkRepository
) : MviViewModel<MainScreenState, MainScreenSideEffect, MainScreenEvent>(initialState = MainScreenState()) {

    override fun dispatch(event: MainScreenEvent) {
        when (event) {
            //todo send enum class and check later with when()
            MainScreenEvent.OnGifsClick -> onGifClick()
            MainScreenEvent.OnImagesClick -> onPicturesClick()
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