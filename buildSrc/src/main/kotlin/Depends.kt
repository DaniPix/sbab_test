object Depends {

    object Classpath {
        const val gradle = "com.android.tools.build:gradle:${Versions.androidGradleVersion}"
        const val serialization =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinVersion}"
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
        const val kotlinxSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0"
        const val kotlinxRetrofitAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.5.0"
    }

    object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.daggerVersion}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    }

    object Internal {
        const val flickrSearch = ":flickrSearch"
    }

    object Lifecycle {
        const val lifecycleRuntime =
            "androidx.lifecycle:lifecycle-runtime:${Versions.lifeCycleVersion}"
        const val lifecycleExtensions =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycleVersion}"
        const val lifecycleCompiler =
            "androidx.lifecycle:lifecycle-common-java8:${Versions.lifeCycleVersion}"
        const val lifeCycleRunTimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleVersion}"
        const val lifeCycleViewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleVersion}"
        const val lifeCycleLiveDataKtx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleVersion}"
    }

    object Image {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    }

    object Coroutines {
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}"
        const val test =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineVersion}"
    }

    object AndroidX {
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityVersion}"
        const val activity = "androidx.activity:activity:${Versions.activityVersion}"
        const val coreKtx = "androidx.core:core-ktx:1.1.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.2"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0-beta01"
        const val supportv4 = "androidx.legacy:legacy-support-v4:1.0.0"
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val annotations = "androidx.annotation:annotation:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
    }

    object Network {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    }

    const val googleMaterial = "com.google.android.material:material:1.1.0"

    object Versions {
        const val minSdkVersion = 23
        const val targetSdkVersion = 29
        const val compileSdkVersion = 29
        const val activityVersion = "1.1.0"
        const val glideVersion = "4.11.0"
        const val okHttpVersion = "4.4.1"
        const val retrofitVersion = "2.7.2"
        const val androidGradleVersion = "4.1.0-alpha08"
        const val kotlinVersion = "1.3.72"
        const val daggerVersion = "2.27"
        const val coroutineVersion = "1.3.3"
        const val lifeCycleVersion = "2.2.0"
    }
}