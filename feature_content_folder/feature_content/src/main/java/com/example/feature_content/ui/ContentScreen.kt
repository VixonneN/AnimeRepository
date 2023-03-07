package com.example.feature_content.ui

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState
import com.example.feature_content_data.network.model.DataGifResult
import com.example.feature_content_data.network.model.DataImagesResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
            ListImageContent(listData = screenState.listImagesData, onEvent = event)
        }
        screenState.listGifsData.isNotEmpty() -> {
            ListGifsContent(listData = screenState.listGifsData, onEvent = event)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ListImageContent(listData: List<DataImagesResults>, onEvent: (ContentEvent) -> Unit) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(listData) { itemResult ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = itemResult.artistName)
                    GlideImage(
                        model = itemResult.url,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            coroutineScope.launch(Dispatchers.IO) {
                                val bitmap = Glide.with(context)
                                    .asBitmap()
                                    .load(itemResult.url)
                                    .submit()
                                    .get()
                                onEvent(ContentEvent.LoadPng(bitmap))
                            }
                        }
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ListGifsContent(listData: List<DataGifResult>, onEvent: (ContentEvent) -> Unit) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(listData) { itemResult ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = itemResult.animeName)
                    GlideImage(
                        model = itemResult.url,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            loadGif(coroutineScope, context, itemResult.url, onEvent)
                        }
                    )

                }
            }
        }
    }
}

private fun loadGif(coroutineScope: CoroutineScope, context: Context, url: String, onEvent:(ContentEvent) -> Unit) {
    coroutineScope.launch(Dispatchers.IO) {
        val result = Glide.with(context)
            .asGif()
            .load(url)
            .submit()
            .get()
        onEvent(ContentEvent.LoadGif(result))
    }
}