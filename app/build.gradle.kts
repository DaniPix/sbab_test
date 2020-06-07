plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {

    buildFeatures {
        buildConfig = true
    }

    compileSdkVersion(Depends.Versions.compileSdkVersion)


    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    defaultConfig {
        applicationId = "com.sbab.test.android"
        minSdkVersion(Depends.Versions.minSdkVersion)
        targetSdkVersion(Depends.Versions.targetSdkVersion)
        versionCode = 1
        versionName = "1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = false
    }


    viewBinding {
        buildFeatures.viewBinding = true
    }

    buildTypes {
        getByName(Build.BuildVariant.debug) {
            signingConfig = signingConfigs.findByName(Build.SigningConfig.debug)
            buildConfigField("boolean", "STORE_RELEASE", "false")
            versionNameSuffix = "-debug"
            multiDexEnabled = true
            isMinifyEnabled = false

            proguardFiles("proguard-android.txt", "proguard-project-debug.txt")
        }

        getByName(Build.BuildVariant.release) {
            buildConfigField("boolean", "STORE_RELEASE", "true")

            multiDexEnabled = true
            isMinifyEnabled = true
            proguardFiles("proguard-android.txt")
        }
    }

    androidExtensions {
        isExperimental = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(Depends.Internal.flickrSearch))
    implementation(Depends.AndroidX.activityKtx)
    implementation(Depends.AndroidX.coreKtx)
    implementation(Depends.AndroidX.fragmentKtx)
    implementation(Depends.AndroidX.cardview)
    implementation(Depends.AndroidX.annotations)
    implementation(Depends.AndroidX.constraintLayout)
    implementation(Depends.Coroutines.android)
    implementation(Depends.Coroutines.core)
    implementation(Depends.Image.glide)
    implementation(Depends.Dagger.core)
    kapt(Depends.Dagger.compiler)
    implementation(Depends.Network.okhttp)
    implementation(Depends.Network.loggingInterceptor)
    implementation(Depends.Network.retrofit)
    implementation(Depends.Kotlin.kotlinxRetrofitAdapter)
    implementation(Depends.Kotlin.kotlinxSerialization)
    implementation(Depends.Lifecycle.lifecycleCompiler)
    implementation(Depends.Lifecycle.lifeCycleRunTimeKtx)
    implementation(Depends.Lifecycle.lifeCycleViewModelKtx)
    implementation(Depends.Lifecycle.lifeCycleLiveDataKtx)
    implementation(Depends.Lifecycle.lifecycleRuntime)
    implementation(Depends.googleMaterial)
}