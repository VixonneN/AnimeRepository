package ru.khomichenko.feature_main.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.khomichenko.feature_main.view_model.MainViewModel

@Composable
fun StartMainScreen(navController: NavController, scaffoldState: ScaffoldState){

    val viewModel: MainViewModel = hiltViewModel()
    LaunchedEffect(key1 = Unit) {
        viewModel.makeRequest()
    }
}