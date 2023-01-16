package ru.khomichenko.feature_main.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.khomichenko.feature_main.states.MainScreenEvent
import ru.khomichenko.feature_main.states.MainScreenState
import ru.khomichenko.feature_main.ui.elements.BigMainButton
import ru.khomichenko.feature_main.view_model.MainViewModel

@Composable
fun MainScreen(
    scaffoldState: ScaffoldState,
    mainScreenState: MainScreenState,
    onEvent: (MainScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    val viewModel: MainViewModel = hiltViewModel()
//    LaunchedEffect(key1 = Unit) {
//        viewModel.makeRequest()
//    }

    when {
        mainScreenState.loading -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        else -> {
            ColumnButtons(modifier = modifier)
            //todo переход на списки гифок/картинок
        }
    }
}

@Composable
fun ColumnButtons(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BigMainButton(text = "Gifs") {
            //todo
        }
        Spacer(modifier = modifier.padding(24.dp))
        BigMainButton(text = "Images") {
            //todo
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ColumnButtonsPreview() {
    ColumnButtons(modifier = Modifier)
}