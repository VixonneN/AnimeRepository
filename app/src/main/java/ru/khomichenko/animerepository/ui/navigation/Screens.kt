package ru.khomichenko.animerepository.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(val route: String, val arguments: List<NamedNavArgument>) {
    object MainScreen : Screens(route = "main_screen", arguments = emptyList())
    object ListTypesContentScreens : Screens(
        route = "list_types/{$TYPE_CONTENT}",
        arguments = listOf(navArgument(TYPE_CONTENT) { type = NavType.StringType })
    ) {
        fun route(
            typeContent: String
        ): String = "list_types/$typeContent"
    }

    object ContentScreen: Screens(
        route = "content/{$TYPE_CONTENT}/{$TYPE}",
        arguments = listOf(
            navArgument(TYPE_CONTENT) { type = NavType.StringType },
            navArgument(TYPE) { type = NavType.StringType }
        )
    ) {
        fun route(
            typeContent: String,
            type: String
        ) : String = "content/$typeContent/$type"
    }

    companion object {
        const val TYPE_CONTENT = "type_content"
        const val TYPE = "type"
    }
}