@file:Suppress("unused")

import org.gradle.api.JavaVersion

object Config {
    val compatibleJavaVersion = JavaVersion.VERSION_18
    const val jvmTarget = "18"
    const val kotlinVersion = "1.7.20"
    const val gradleAndroidVersion = "7.4.0"
    const val daggerVersion = "2.44"
}

object Android {
    const val applicationId = "ru.khomichenko.animerepository"
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33

    const val versionCode = 1
    const val versionName = "0.0.$versionCode"

    const val testInstrumentalRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Obfuscation {
    const val releaseMinifyEnabled = true
    const val debugMinifyEnabled = false
    const val releaseDebuggable = false
    const val debugDebuggable = true
}

object Plugins {
    const val application = "com.android.application"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val parcelable = "kotlin-parcelize"
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val kapt = "kotlin-kapt"
    const val androidLibrary = "com.android.library"
}

object Project {
    object Dagger {
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Config.daggerVersion}"
    }
    object Android {
        const val androidGradle = "com.android.tools.build:gradle:7.4.0"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Config.kotlinVersion}"
    }
}

object Libs {
    object View {
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val coreKtx = "androidx.core:core-ktx:1.9.0"
        const val material = "com.google.android.material:material:1.7.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.5"

        object Test {
            const val jUnit = "junit:junit:4.13.2"
            const val mockito = "org.mockito:mockito-core:4.1.0"
            const val unit_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
        }
        object AndroidTest {
            const val jUnit = "androidx.test.ext:junit:1.1.5"
            const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
        }
    }
    object Compose {
        const val composeVersion = "1.3.2"
        private const val accompanist = "0.28.0"
        private const val coil = "2.2.2"

        const val ui = "androidx.compose.ui:ui:$composeVersion"
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val material = "androidx.compose.material:material:1.3.1"
        const val activity = "androidx.activity:activity-compose:1.6.1"

        const val navigation = "com.google.accompanist:accompanist-navigation-animation:$accompanist"

        const val coilCompose = "io.coil-kt:coil-compose:$coil"
        const val coilSvg = "io.coil-kt:coil-svg:$coil"
        const val coilGifs = "io.coil-kt:coil-gif:$coil"


        object Test {
            const val uiJunit = "androidx.compose.ui:ui-test-junit4:$composeVersion"
            const val uiManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"
        }

        object Debug {
            const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"
        }
    }

    object Application {
        object Orbit {
            private const val orbitVersion = "4.3.2"

            const val orbitViewModel = "org.orbit-mvi:orbit-viewmodel:$orbitVersion"
            const val orbitCompose = "org.orbit-mvi:orbit-compose:$orbitVersion"
        }

        object DependencyInjection {
            private const val koinVersion = "3.3.3"
            private const val koinCompose = "3.4.2"

            const val hilt = "com.google.dagger:hilt-android:${Config.daggerVersion}"
            const val kaptDagger = "com.google.dagger:hilt-compiler:${Config.daggerVersion}"
            const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"

            const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
            const val koinAndroidCompose = "io.insert-koin:koin-androidx-compose:$koinCompose"
        }

        object Network {
            private const val retrofitVersion = "2.9.0"
            private const val okHttpVersion = "4.10.0"
            private const val moshiVersion = "1.14.0"

            const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
            const val converter_gson = "com.squareup.retrofit2:converter-gson::$retrofitVersion"
            const val okhttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
            const val okhttp_login_interceptor = "com.squareup.okhttp3:logging-interceptor:${okHttpVersion}"

            const val moshi = "com.squareup.moshi:moshi:$moshiVersion"
            const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
            const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$moshiVersion"
            const val kaptMoshi = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
            const val converter_moshi = "com.squareup.retrofit2:converter-moshi:2.9.0"
        }

        object Database {
            private const val roomVersion = "2.4.3"

            const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
            const val kaptRoom = "androidx.room:room-compiler:$roomVersion"
            const val roomKtx = "androidx.room:room-ktx:$roomVersion"
            const val roomPadding = "androidx.room:room-paging:$roomVersion"
        }

        object Coroutines {
            private const val version = "1.6.3"

            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }
}

object Modules {
    const val app = ":app"
    const val data = ":data"
    const val domain = ":domain"
    const val core = ":core"
    const val featureMain = ":feature_formats:feature_main"
    const val featureMainData = ":feature_formats:feature_main_data"
    const val featureListTypes = ":feature_list_content_network:feature_list_content"
    const val network = ":network"
    const val featureContent = ":feature_content"
}