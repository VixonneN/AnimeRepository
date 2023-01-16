package ru.khomichenko.animerepository.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.khomichenko.feature_main.states.MainScreenEvent
import ru.khomichenko.feature_main.states.MainScreenSideEffect
import ru.khomichenko.feature_main.ui.MainScreen
import ru.khomichenko.feature_main.view_model.MainViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedNavigation(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        addMainScreen(navController, scaffoldState)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMainScreen(
    navController: NavController,
    scaffoldState: ScaffoldState
) {
    composable(route = Screens.MainScreen.route) {

        val mainViewModel: MainViewModel = hiltViewModel()
        val mainScreenState = mainViewModel.collectAsState().value

        MainScreen(
            scaffoldState = scaffoldState,
            mainScreenState = mainScreenState,
            onEvent = { mainViewModel.dispatch(it) }
        )

        mainViewModel.collectSideEffect {
            handleSideEffect(
                mainScreenSideEffect = it,
                navController = navController
            )
        }
    }
}

private fun handleSideEffect(
    mainScreenSideEffect: MainScreenSideEffect,
    navController: NavController
) {
    when(mainScreenSideEffect) {
        MainScreenSideEffect.NavigateToSecondScreen -> {
            navController.navigate(Screens.MainScreen.route)
        }
    }

}