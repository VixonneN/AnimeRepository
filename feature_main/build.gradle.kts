@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.kapt)
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
    id(Plugins.daggerHilt)
}

android {
    namespace = "ru.khomichenko.feature_main"
    compileSdk = Android.compileSdk

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compose.composeVersion
    }
}

dependencies {

    implementation(Libs.Application.DependencyInjection.hilt)
    kapt(Libs.Application.DependencyInjection.kaptDagger)

    implementation(Libs.View.coreKtx)
    implementation(Libs.View.lifecycleRuntime)

    implementation(Libs.Compose.activity)
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.preview)
    implementation(Libs.Compose.material)
    implementation(Libs.Application.DependencyInjection.hiltNavigationCompose)

    testImplementation(Libs.View.Test.jUnit)

    androidTestImplementation(Libs.View.AndroidTest.jUnit)
    androidTestImplementation(Libs.View.AndroidTest.espresso)
    androidTestImplementation(Libs.Compose.Test.uiJunit)
    androidTestImplementation(Libs.Compose.Test.uiManifest)

    debugImplementation(Libs.Compose.Debug.uiTooling)
    debugImplementation(Libs.Compose.Debug.uiTestManifest)

    implementation(project(Modules.domain))
    implementation(project(Modules.core))
}