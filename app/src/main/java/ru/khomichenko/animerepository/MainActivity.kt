package ru.khomichenko.animerepository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import ru.khomichenko.animerepository.ui.navigation.AnimatedNavigation
import ru.khomichenko.animerepository.ui.theme.AnimeRepositoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeRepositoryTheme {
                // A surface container using the 'background' color from the theme
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    scaffoldState = scaffoldState,
                ) {
                    AnimatedNavigation(scaffoldState = scaffoldState, modifier = Modifier
                        .padding(paddingValues = it)
                        .fillMaxSize()
                    )
                }
            }
        }
    }
}