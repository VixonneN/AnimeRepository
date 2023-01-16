package ru.khomichenko.feature_main.states

sealed class MainScreenSideEffect {
    object NavigateToSecondScreen: MainScreenSideEffect()
}
