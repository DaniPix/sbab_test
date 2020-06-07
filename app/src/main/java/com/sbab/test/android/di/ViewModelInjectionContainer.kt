package com.sbab.test.android.di

import com.sbab.test.android.search.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
interface ViewModelInjectionContainer {
    @FlowPreview
    val searchViewModel: SearchViewModel
}