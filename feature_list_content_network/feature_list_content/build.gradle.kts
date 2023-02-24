plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
}

android {
    namespace = "ru.khomichenko.feature_list_content"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.Compose.kotlinCompiler
    }
}

dependencies {

    implementation(Libs.Application.DependencyInjection.koinAndroid)
    implementation(Libs.Application.DependencyInjection.koinAndroidCompose)

    implementation(Libs.View.coreKtx)
    implementation(Libs.View.lifecycleRuntime)

    implementation(Libs.Application.Orbit.orbitCompose)
    implementation(Libs.Application.Orbit.orbitViewModel)

    implementation(platform(Libs.Boom.composeBoom))
    implementation(Libs.Boom.activityCompose)
    implementation(Libs.Boom.composeUi)
    implementation(Libs.Boom.material2)
    implementation(Libs.Boom.toolingPreviw)
    debugImplementation(Libs.Boom.debugUiTooling)
    androidTestImplementation(Libs.Boom.composeBoom)

    testImplementation(Libs.View.Test.jUnit)

    androidTestImplementation(Libs.View.AndroidTest.jUnit)
    androidTestImplementation(Libs.View.AndroidTest.espresso)
    androidTestImplementation(Libs.Compose.Test.uiJunit)
    androidTestImplementation(Libs.Compose.Test.uiManifest)

    debugImplementation(Libs.Compose.Debug.uiTooling)
    debugImplementation(Libs.Compose.Debug.uiTestManifest)

    implementation(project(Modules.core))
}