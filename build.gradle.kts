buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Project.Android.androidGradle)
        classpath(Project.Android.kotlinGradle)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
