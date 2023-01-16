package ru.khomichenko.feature_main.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.khomichenko.domain.network.use_case.SleepingGifsUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sleepUseCase: SleepingGifsUseCase
) : ViewModel() {

    fun makeRequest() {
        viewModelScope.launch {
            sleepUseCase()
        }
    }
}