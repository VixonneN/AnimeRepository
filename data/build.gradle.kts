plugins {
    id(Plugins.kapt)
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
    id(Plugins.daggerHilt)
}

android {
    namespace = "ru.khomichenko.data"
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
}

dependencies {
    implementation(Libs.Application.DependencyInjection.hilt)
    kapt(Libs.Application.DependencyInjection.kaptDagger)

    implementation(Libs.Application.Network.retrofit)
    implementation(Libs.Application.Network.okhttp)
    implementation(Libs.Application.Network.moshi)
    kapt(Libs.Application.Network.kaptMoshi)
    implementation(Libs.Application.Network.okhttp_login_interceptor)

    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    implementation(Libs.Application.Database.roomRuntime)
    implementation(Libs.Application.Database.roomKtx)
    kapt(Libs.Application.Database.kaptRoom)
    implementation(Libs.Application.Database.roomPadding)

    implementation(Libs.Application.Coroutines.coroutines)

    implementation(project(Modules.domain))
    implementation(project(Modules.core))
}