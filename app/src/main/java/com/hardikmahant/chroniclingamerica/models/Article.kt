package com.hardikmahant.chroniclingamerica.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "Articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val articleId: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
): Serializable