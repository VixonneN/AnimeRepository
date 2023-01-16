package ru.khomichenko.feature_main.states

sealed class MainScreenEvent {
    object OnButtonClick: MainScreenEvent()
    object LoadSomeAnimeStaff: MainScreenEvent()
}
