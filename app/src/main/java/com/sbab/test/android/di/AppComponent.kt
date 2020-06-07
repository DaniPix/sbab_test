package com.sbab.test.android.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Component(
    modules = [
        SearchModule::class
    ]
)

@Singleton
interface AppComponent : ViewModelInjectionContainer {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}