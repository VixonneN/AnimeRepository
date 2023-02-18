@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
}

android {
    namespace = "ru.khomichenko.core"
    compileSdk = Android.compileSdk

    defaultConfig {
        minSdk = Android.minSdk

        testInstrumentationRunner = Android.testInstrumentalRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = Obfuscation.releaseMinifyEnabled

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
        debug {
            isMinifyEnabled = Obfuscation.debugMinifyEnabled

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.compatibleJavaVersion
        targetCompatibility = Config.compatibleJavaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    implementation(Libs.Application.Network.retrofit)
    implementation(Libs.View.lifecycleRuntime)
    implementation(Libs.Application.Orbit.orbitViewModel)
    implementation(Libs.View.lifecycleRuntime)
    implementation(Libs.View.lifecycleViewModel)

    testImplementation(Libs.View.Test.jUnit)

    androidTestImplementation(Libs.View.AndroidTest.jUnit)
    androidTestImplementation(Libs.View.AndroidTest.espresso)
}