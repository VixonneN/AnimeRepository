package ru.khomichenko.animerepository.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screens(val route: String, val arguments: List<NamedNavArgument>) {
    object MainScreen : Screens(route = "main_screen", arguments = emptyList())
}