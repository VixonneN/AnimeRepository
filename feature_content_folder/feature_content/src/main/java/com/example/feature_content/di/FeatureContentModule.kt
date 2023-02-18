package com.example.feature_content.di

import com.example.feature_content.view_model.ContentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FeatureContentModule {

    val module = module {
        viewModel { ContentViewModel() }
    }
}