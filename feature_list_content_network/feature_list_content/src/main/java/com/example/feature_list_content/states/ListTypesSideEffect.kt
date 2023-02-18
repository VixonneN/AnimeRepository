package com.example.feature_list_content.states

sealed class ListTypesSideEffect {
    data class NavigateToSecondScreen(val typeContent: String, val type: String): ListTypesSideEffect()
}
