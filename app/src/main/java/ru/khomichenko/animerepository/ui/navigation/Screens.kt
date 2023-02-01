package ru.khomichenko.animerepository.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(val route: String, val arguments: List<NamedNavArgument>) {
    object MainScreen : Screens(route = "main_screen", arguments = emptyList())
    object ListTypesContentScreens : Screens(
        route = "list_types/{type_content}",
        arguments = listOf(navArgument("type_content") { type = NavType.StringType })
    ) {
        fun route(
            typeContent: String
        ): String = "list_types/$typeContent"
    }
}