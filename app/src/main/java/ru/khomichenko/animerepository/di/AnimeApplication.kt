package ru.khomichenko.animerepository.di

import android.app.Application
import com.example.feature_content.di.FeatureContentModule
import com.example.feature_list_content.di.FeatureTypesContentModule
import com.example.feature_main_data.di.NetworkContentModule
import com.example.network.NetworkInitializationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.khomichenko.animerepository.BuildConfig
import ru.khomichenko.feature_main.main.di.FeatureMainModule

class AnimeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG ) Level.ERROR else Level.NONE)
            androidContext(applicationContext)
            modules(modules)
        }
    }

    private val modules = listOf(
        NetworkInitializationModule.module,
        NetworkContentModule.module,
        FeatureTypesContentModule.module,
        FeatureContentModule.module,
        FeatureMainModule.module
    )
}