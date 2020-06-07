package com.sbab.test.android

import com.sbab.test.android.api.SearchService
import com.sbab.test.android.data.SearchResult
import com.sbab.test.android.data.transformToSearchResult
import javax.inject.Inject

internal class SearchRepository @Inject constructor(
    private val searchService: SearchService,
    private val appConfig: AppConfig
) : ISearchRepository {

    override suspend fun searchPhotos(query: String): SearchState {

        val response = searchService.searchPhotos(
            query = query,
            apiKey = appConfig.flickrApiKey
        )

        val body = response.body()

        if (response.isSuccessful && body != null) {
            return SearchState.Success(
                body.transformToSearchResult()
            )
        }

        return SearchState.Failure
    }
}


interface ISearchRepository {

    suspend fun searchPhotos(query: String): SearchState

}

sealed class SearchState {
    object Failure : SearchState()
    object Loading : SearchState()
    class Success(val searchResult: List<SearchResult>) : SearchState()
}