@file:OptIn(ExperimentalGlideComposeApi::class)

package com.example.feature_content.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState
import com.example.feature_content_data.network.model.DataResults

@Composable
fun ContentScreen(
    scaffoldState: ScaffoldState,
    screenState: ContentScreenState,
    event: (ContentEvent) -> Unit
) {

    when {
        screenState.loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        screenState.listImagesData.isNotEmpty() -> {
            ListContent(listData = screenState.listImagesData)
        }
    }
}

@Composable
private fun ListContent(listData: List<DataResults>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(listData) { itemResult ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = itemResult.artistName)
                    GlideImage(
                        model = itemResult.url,
                        contentDescription = null
                    )
                }
            }
        }
    }
}