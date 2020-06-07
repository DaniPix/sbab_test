package com.sbab.test.android

import android.content.Context
import com.sbab.test.android.api.SearchService
import retrofit2.Retrofit

object SearchRepositoryFactory {

    @Volatile
    private var instance: ISearchRepository? = null

    fun getInstance(retrofit: Retrofit): ISearchRepository {

        return instance ?: synchronized(this) {
            instance ?: SearchRepository(
                searchService = retrofit.create(SearchService::class.java),
                appConfig = AppConfig
            ).also {
                instance = it
            }
        }
    }
}