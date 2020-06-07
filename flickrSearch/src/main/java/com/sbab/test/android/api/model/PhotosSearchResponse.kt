package com.sbab.test.android.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PhotosSearchResponse(
    @SerialName("photos")
    val response: Photos,
    @SerialName("stat")
    val status: String
)

@Serializable
internal data class Photos(
    @SerialName("page")
    val page: Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("perpage")
    val perPage: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("photo")
    val photoList: List<Photo>
)

@Serializable
internal data class Photo(
    @SerialName("id")
    val id: String,
    @SerialName("owner")
    val owner: String,
    @SerialName("secret")
    val secret: String,
    @SerialName("server")
    val server: String,
    @SerialName("farm")
    val farm: Int,
    @SerialName("title")
    val title: String,
    @SerialName("ispublic")
    val isPublic: Int,
    @SerialName("isfriend")
    val isFriend: Int,
    @SerialName("isfamily")
    val isFamily: Int
)