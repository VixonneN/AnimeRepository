@file:OptIn(ExperimentalAnimationApi::class)

package ru.khomichenko.animerepository.ui.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentSideEffect
import com.example.feature_content.ui.ContentScreen
import com.example.feature_content.view_model.ContentViewModel
import com.example.feature_list_content.states.ListTypesContentEvent
import com.example.feature_list_content.states.ListTypesSideEffect
import com.example.feature_list_content.ui.ListTypesContentScreen
import com.example.feature_list_content.view_model.ListTypesContentViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import ru.khomichenko.feature_main.main.states.MainScreenSideEffect
import ru.khomichenko.feature_main.main.ui.MainScreen
import ru.khomichenko.feature_main.main.view_model.MainViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedNavigation(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(
            route = Screens.MainScreen.route
        ) {
            val mainViewModel: MainViewModel = koinViewModel()
            val screenState = mainViewModel.collectAsState().value

            MainScreen(
                scaffoldState = scaffoldState,
                mainScreenState = screenState,
                onEvent = { mainViewModel.dispatch(it) })

            mainViewModel.collectSideEffect { sideEffect ->
                when (sideEffect) {
                    is MainScreenSideEffect.NavigateToGifScreen -> {
                        navController.navigate(
                            route = Screens.ListTypesContentScreens.route(sideEffect.contentType)
                        )
                    }
                    is MainScreenSideEffect.NavigateToImageScreen -> {
                        navController.navigate(
                            route = Screens.ListTypesContentScreens.route(sideEffect.contentType)
                        )
                    }
                }
            }
        }

        composable(
            route = Screens.ListTypesContentScreens.route,
            arguments = Screens.ListTypesContentScreens.arguments
        ) { bundle ->
            val viewModel: ListTypesContentViewModel = koinViewModel()
            val screenState = viewModel.collectAsState().value

            val typeScreen = bundle.arguments?.getString("type_content") ?: ""

            LaunchedEffect(key1 = Unit, block = {
                viewModel.dispatch(ListTypesContentEvent.SelectCorrectContentType(typeScreen))
            })

            ListTypesContentScreen(
                scaffoldState = scaffoldState,
                screenState = screenState,
                event = { viewModel.dispatch(it) }
            )

            viewModel.collectSideEffect { sideEffect ->
                when (sideEffect) {

                    is ListTypesSideEffect.NavigateToSecondScreen -> {
                        Log.e("TAG", "ListTypesContentScreens: typeContent = ${sideEffect.typeContent}")
                        Log.e("TAG", "ListTypesContentScreens: type = ${sideEffect.type}")
                        navController.navigate(Screens.ContentScreen.route(
                            typeContent = sideEffect.typeContent,
                            type = sideEffect.type
                        ))
                    }
                }
            }
        }

        composable(
            route = Screens.ContentScreen.route,
            arguments = Screens.ContentScreen.arguments
        ) { navBachStackEntry ->
            val viewModel: ContentViewModel = koinViewModel()
            val screenState = viewModel.collectAsState().value

            val typeContent = navBachStackEntry.arguments?.getString(Screens.TYPE_CONTENT) ?: ""
            val type = navBachStackEntry.arguments?.getString(Screens.TYPE) ?: ""

            Log.e("TAG", "AnimatedNavigation: typeContent = $typeContent")
            Log.e("TAG", "AnimatedNavigation: type = $type")

            LaunchedEffect(key1 = Unit, block = {
                viewModel.dispatch(ContentEvent.LoadContent(typeContent = typeContent, type = type))
            })

            ContentScreen(
                scaffoldState = scaffoldState,
                screenState = screenState,
                event = { viewModel.dispatch(it) }
            )

            viewModel.collectSideEffect { sideEffect ->

            }
        }
    }
}

