package com.sbab.test.android.data

import com.sbab.test.android.api.model.PhotosSearchResponse

internal fun PhotosSearchResponse.transformToSearchResult(): List<SearchResult> {

    return this.response.photoList.map {
        SearchResult(
            photoUrl = buildPhotoUrl(it.farm, it.server, it.id, it.secret, "jpg"),
            photoTitle = it.title
        )
    }
}

internal fun buildPhotoUrl(
    farm: Int,
    server: String,
    id: String,
    secret: String,
    format: String
) = "https://farm${farm}.staticflickr.com/${server}/${id}_${secret}_q.${format}"
