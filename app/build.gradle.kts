@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.application)
    id(Plugins.kotlin)
    id(Plugins.daggerHilt)
    id(Plugins.kapt)
}

android {
    namespace = Android.applicationId
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = Android.testInstrumentalRunner

        //idk, need to read
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isDebuggable = Obfuscation.releaseDebuggable
            isMinifyEnabled = Obfuscation.releaseMinifyEnabled
            isShrinkResources = Obfuscation.releaseMinifyEnabled

            //later create signing key for Google Play
            signingConfig = signingConfigs.getByName("debug")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
        debug {
            isDebuggable = Obfuscation.debugDebuggable
            isMinifyEnabled = Obfuscation.debugMinifyEnabled
            isShrinkResources = Obfuscation.debugMinifyEnabled

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
    packagingOptions {
        resources {
            resources.excludes.add("META-INF/AL2.0")
            resources.excludes.add("META-INF/LGPL2.1")
        }
    }
}

dependencies {
    implementation(Libs.Application.DependencyInjection.hilt)
    kapt(Libs.Application.DependencyInjection.kaptDagger)

    implementation(Libs.View.coreKtx)
    implementation(Libs.View.lifecycleRuntime)

    implementation(Libs.Application.Network.retrofit)
    implementation(Libs.Application.Network.okhttp)
    implementation(Libs.Application.Network.moshi)
    kapt(Libs.Application.Network.kaptMoshi)
    implementation(Libs.Application.Network.okhttp_login_interceptor)

    implementation(Libs.Application.Database.roomRuntime)
    implementation(Libs.Application.Database.roomKtx)
    kapt(Libs.Application.Database.kaptRoom)
    implementation(Libs.Application.Database.roomPadding)

    implementation(Libs.Compose.activity)
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.preview)
    implementation(Libs.Compose.material)
    implementation(Libs.Application.DependencyInjection.hiltNavigationCompose)

    implementation(Libs.Compose.navigation)

    implementation(Libs.Application.Orbit.orbitCompose)
    implementation(Libs.Application.Orbit.orbitViewModel)

    testImplementation(Libs.View.Test.jUnit)

    androidTestImplementation(Libs.View.AndroidTest.jUnit)
    androidTestImplementation(Libs.View.AndroidTest.espresso)
    androidTestImplementation(Libs.Compose.Test.uiJunit)
    androidTestImplementation(Libs.Compose.Test.uiManifest)

    debugImplementation(Libs.Compose.Debug.uiTooling)
    debugImplementation(Libs.Compose.Debug.uiTestManifest)

    implementation(project(Modules.core))
    implementation(project(Modules.domain))
    implementation(project(Modules.featureMain))
    implementation(project(Modules.data))
    implementation(project(Modules.featureListTypes))
}