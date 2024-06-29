package com.example.dailypulse.articles

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticleUseCase(private val service: ArticleService) {

    suspend fun getArticles(): List<Article> {
        val articleRaws = service.fetchArticles()
        return mapArticles(articleRaws)
    }

    private fun mapArticles(articleRaws: List<ArticleRaw>): List<Article> = articleRaws.map { raw ->
        Article(
            title = raw.title,
            description = raw.desc ?: "Click to find out more",
            date = getDaysAgoString(raw.date),
            imageUrl = raw.imageUrl ?: "https://picsum.photos/id/1/1000/500"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        return when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
    }
}