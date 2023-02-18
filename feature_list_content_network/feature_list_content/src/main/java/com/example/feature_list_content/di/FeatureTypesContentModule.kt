package com.example.feature_list_content.di

import com.example.feature_list_content.view_model.ListTypesContentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FeatureTypesContentModule {
    val module = module {
        viewModel {
            ListTypesContentViewModel()
        }
    }
}