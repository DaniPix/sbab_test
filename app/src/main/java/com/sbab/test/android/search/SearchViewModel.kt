package com.sbab.test.android.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sbab.test.android.ISearchRepository
import com.sbab.test.android.SearchState
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@FlowPreview
@ExperimentalCoroutinesApi
class SearchViewModel @Inject constructor(
    private val searchRepository: ISearchRepository
) : ViewModel() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.IO
    private val scope = CoroutineScope(coroutineContext)
    private val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    var searchQuery: String = ""

    val searchResult = MutableLiveData<SearchState>()


    init {
        scope.launch {
            queryChannel
                .asFlow()
                .debounce(300)
                .filter { it.isNotEmpty() }
                .mapLatest { query ->
                    try {
                        searchQuery = query
                        searchRepository.searchPhotos(query)
                    } catch (e: Exception) {
                        SearchState.Failure
                    }
                }.collect {
                    searchResult.postValue(it)
                }
        }
    }

    fun search(query: CharSequence) {
        scope.launch {
            queryChannel.send(query.toString())
        }
    }

    override fun onCleared() {
        scope.cancel()
        super.onCleared()
    }
}