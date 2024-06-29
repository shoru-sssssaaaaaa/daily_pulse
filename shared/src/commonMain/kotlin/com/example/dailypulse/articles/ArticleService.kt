package com.example.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {

    private val country: String = "jp"
    private val category: String = "business"
    private val apiKey: String = "fb4f9e23d65b41508087afaa73466dbc"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticleResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}