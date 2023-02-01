package ru.khomichenko.feature_main.main.states

sealed class MainScreenEvent {
    object OnGifsClick: MainScreenEvent()
    object OnImagesClick: MainScreenEvent()
}
