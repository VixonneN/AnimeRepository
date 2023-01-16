package ru.khomichenko.animerepository.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ru.khomichenko.feature_main.ui.StartMainScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedNavigation(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(
            route = Screens.MainScreen.route,
            arguments = Screens.MainScreen.arguments
        ) {
            StartMainScreen(navController = navController, scaffoldState = scaffoldState)
        }
    }
}