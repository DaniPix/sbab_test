package com.sbab.test.android.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sbab.test.android.AppConfig
import com.sbab.test.android.ISearchRepository
import com.sbab.test.android.SearchRepositoryFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@Module
object SearchModule {

    @Provides
    @Reusable
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                readTimeout(5, TimeUnit.SECONDS)
                writeTimeout(5, TimeUnit.SECONDS)
                connectTimeout(5, TimeUnit.SECONDS)
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build()
    }

    @Provides
    @Reusable
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Reusable
    fun provideAppConfig(): AppConfig = AppConfig

    @Provides
    @Reusable
    fun provideSearchRepository(retrofit: Retrofit): ISearchRepository {
        return SearchRepositoryFactory.getInstance(retrofit)
    }
}