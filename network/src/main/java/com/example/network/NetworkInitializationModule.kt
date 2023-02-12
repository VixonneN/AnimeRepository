package com.example.network

import org.koin.dsl.module

object NetworkInitializationModule {

    val module = module {
        single { NetworkService(networkFactory = NetworkFactory()).serviceRetrofit }
    }
}