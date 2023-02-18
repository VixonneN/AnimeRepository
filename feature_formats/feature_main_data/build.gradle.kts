plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
    id(Plugins.kapt)
}

android {
    namespace = "ru.khomichenko.feature_main_data"
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
    implementation(Libs.Application.DependencyInjection.koinAndroid)
    implementation(Libs.Application.DependencyInjection.koinAndroidCompose)

    implementation(Libs.Application.Network.retrofit)
    implementation(Libs.Application.Network.okhttp)
    implementation(Libs.Application.Network.moshi)
    kapt(Libs.Application.Network.kaptMoshi)
    implementation(Libs.Application.Network.converter_moshi)
    implementation(Libs.Application.Network.okhttp_login_interceptor)

    implementation(Libs.Application.Database.roomRuntime)
    implementation(Libs.Application.Database.roomKtx)
    kapt(Libs.Application.Database.kaptRoom)
    implementation(Libs.Application.Database.roomPaging)

    implementation(Libs.Application.Coroutines.coroutines)

    implementation(project(Modules.core))
}