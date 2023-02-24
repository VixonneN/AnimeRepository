package com.example.network.di

import com.example.network.NetworkFactory
import com.example.network.NetworkService
import org.koin.dsl.module

object NetworkInitializationModule {

    val module = module {
        single { NetworkService(networkFactory = NetworkFactory()).serviceRetrofit }
    }
}