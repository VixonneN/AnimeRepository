plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
}

android {
    namespace = "com.example.feature_content"
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

    implementation(Libs.View.coreKtx)
    implementation(Libs.View.lifecycleRuntime)

    implementation(Libs.Application.Orbit.orbitCompose)
    implementation(Libs.Application.Orbit.orbitViewModel)

    implementation(Libs.Compose.activity)
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.preview)
    implementation(Libs.Compose.material)

    testImplementation(Libs.View.Test.jUnit)

    androidTestImplementation(Libs.View.AndroidTest.jUnit)
    androidTestImplementation(Libs.View.AndroidTest.espresso)
    androidTestImplementation(Libs.Compose.Test.uiJunit)
    androidTestImplementation(Libs.Compose.Test.uiManifest)

    debugImplementation(Libs.Compose.Debug.uiTooling)
    debugImplementation(Libs.Compose.Debug.uiTestManifest)

    implementation(project(Modules.core))
}