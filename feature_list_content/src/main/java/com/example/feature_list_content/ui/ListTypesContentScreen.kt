package com.example.feature_list_content.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringArrayResource
import com.example.feature_list_content.states.ListTypesContentEvent
import com.example.feature_list_content.states.ListTypesScreenState
import ru.khomichenko.feature_list_content.R

@Composable
fun ListTypesContentScreen(
    scaffoldState: ScaffoldState,
    screenState: ListTypesScreenState,
    event: (ListTypesContentEvent) -> Unit
) {
    val gifsList = stringArrayResource(R.array.gifs)
    val picturesList = stringArrayResource(R.array.png)

    when {
        screenState.contentTypePng -> {
            LazyColumn {
                items(picturesList) {
                    Text(it)
                }
            }
        }

        screenState.contentTypeGif -> {
            LazyColumn {
                items(gifsList) {
                    Text(it)
                }
            }
        }
    }
}