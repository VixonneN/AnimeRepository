package com.example.feature_content.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState

@Composable
fun ContentScreen(
    scaffoldState: ScaffoldState,
    screenState: ContentScreenState,
    event:(ContentEvent) -> Unit
) {

}