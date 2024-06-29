package com.example.dailypulse.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val results: Int,
    @SerialName("articles") val articles: List<ArticleRaw>
)

@Serializable
data class ArticleRaw(
    @SerialName("title") val title: String,
    @SerialName("description") val desc: String?,
    @SerialName("publishedAt") val date: String,
    @SerialName("urlToImage") val imageUrl: String?,
)