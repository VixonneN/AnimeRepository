package ru.khomichenko.feature_main.main.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.khomichenko.feature_main.main.view_model.MainViewModel

object FeatureMainModule {
    val module = module {
        viewModel {
            MainViewModel(get())
        }
    }
}