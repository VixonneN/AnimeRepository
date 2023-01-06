plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
}

android {
    namespace = "ru.khomichenko.domain"
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

    implementation(Libs.Application.Coroutines.coroutines)
    implementation(project(Modules.core))

    testImplementation(Libs.View.Test.jUnit)

    androidTestImplementation(Libs.View.AndroidTest.jUnit)
    androidTestImplementation(Libs.View.AndroidTest.espresso)
}