package ru.khomichenko.feature_main.view_model

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.khomichenko.core.utils.MviViewModel
import ru.khomichenko.domain.network.use_case.SleepingGifsUseCase
import ru.khomichenko.feature_main.states.MainScreenEvent
import ru.khomichenko.feature_main.states.MainScreenSideEffect
import ru.khomichenko.feature_main.states.MainScreenState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sleepUseCase: SleepingGifsUseCase
) : MviViewModel<MainScreenState, MainScreenSideEffect, MainScreenEvent>(initialState = MainScreenState()) {

    fun makeRequest() {
        viewModelScope.launch {
            sleepUseCase()
        }
    }

    override fun dispatch(event: MainScreenEvent) {
        when(event) {
            MainScreenEvent.OnButtonClick -> {
                //some event
                onButtonClick()
            }
            MainScreenEvent.LoadSomeAnimeStaff -> {
                loadSomeStaff()
            }
        }
    }
    private fun onButtonClick() {
        intent {
            postSideEffect(MainScreenSideEffect.NavigateToSecondScreen)
        }
    }

    //for example for loading
    private fun loadSomeStaff() {
        intent {
            reduce { state.copy(loading = true) }
            sleepUseCase()
            reduce { state.copy(loading = false) }
        }
    }
}