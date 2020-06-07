plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Depends.Versions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Depends.Versions.minSdkVersion)
        targetSdkVersion(Depends.Versions.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile(file("config/proguard/proguard-rules.txt"))
        }
    }
}

dependencies {
    implementation(Depends.Network.retrofit)
    implementation(Depends.Kotlin.kotlinxSerialization)
    implementation(Depends.Kotlin.stdlib)
    implementation(Depends.Dagger.core)
    kapt(Depends.Dagger.compiler)
}