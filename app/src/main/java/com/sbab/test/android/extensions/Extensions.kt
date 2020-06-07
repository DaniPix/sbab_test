package com.sbab.test.android.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.sbab.test.android.ComponentProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val Activity.injector
    get() = (application as ComponentProvider).component


@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val Fragment.injector
    get() = (activity?.application as ComponentProvider).component

fun <T> LiveData<T>.observe(owner: LifecycleOwner, listener: (T) -> Unit) {
    this.observe(owner, Observer { listener(it) })
}


@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> Fragment.fragmentScopedViewModel(
    crossinline provider: () -> T
) = viewModels<T> {
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>) =
            provider() as T
    }
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> Fragment.activityScopedViewModel(
    crossinline provider: () -> T
) = activityViewModels<T> {
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>) =
            provider() as T
    }
}


