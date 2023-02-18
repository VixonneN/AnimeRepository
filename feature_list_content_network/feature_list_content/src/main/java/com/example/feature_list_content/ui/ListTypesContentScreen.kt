package com.example.feature_list_content.ui

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature_list_content.states.ListTypesContentEvent
import com.example.feature_list_content.states.ListTypesScreenState
import ru.khomichenko.feature_list_content.R

@Composable
fun ListTypesContentScreen(
    scaffoldState: ScaffoldState,
    screenState: ListTypesScreenState,
    event: (ListTypesContentEvent) -> Unit
) {
    val gifsList = stringArrayResource(R.array.gifs).toList()
    val picturesList = stringArrayResource(R.array.png).toList()

    when {
        screenState.contentTypePng -> {
            ListOfTypes(list = picturesList)
        }

        screenState.contentTypeGif -> {
            ListOfTypes(list = gifsList)
        }
    }
}

@Composable
private fun ListOfTypes(list: List<String>) {
    Box {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(list) { item ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember {
                                MutableInteractionSource()
                            }
                        ) {
                            //todo click
                        }
                        .background(
                            color = MaterialTheme.colors.primary,
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(16.dp)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}