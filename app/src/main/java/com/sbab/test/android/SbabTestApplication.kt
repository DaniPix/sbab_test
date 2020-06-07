package com.sbab.test.android

import android.app.Application
import com.sbab.test.android.di.AppComponent
import com.sbab.test.android.di.DaggerAppComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class SbabTestApplication : Application(), ComponentProvider {

    override val component by lazy {
        DaggerAppComponent
            .factory()
            .create(applicationContext)
    }
}

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
interface ComponentProvider {
    val component: AppComponent
}