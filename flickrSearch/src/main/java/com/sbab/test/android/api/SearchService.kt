package com.sbab.test.android.api

import com.sbab.test.android.api.model.PhotosSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


internal interface SearchService {

    @GET("services/rest/")
    suspend fun searchPhotos(
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") apiKey: String,
        @Query("format") format: String = "json",
        @Query("text") query: String,
        @Query("nojsoncallback") noJsonCallback: Int = 1
    ): Response<PhotosSearchResponse>
}