package ru.khomichenko.feature_main.main.states

sealed class MainScreenSideEffect {
    data class NavigateToGifScreen(val contentType: String): MainScreenSideEffect()
    data class NavigateToImageScreen(val contentType: String): MainScreenSideEffect()
}
