package com.hardikmahant.chroniclingamerica.repository

import com.hardikmahant.chroniclingamerica.api.RetrofitInstance
import com.hardikmahant.chroniclingamerica.db.ArticleDatabase
import com.hardikmahant.chroniclingamerica.models.Article
import com.hardikmahant.chroniclingamerica.models.NewsResponse
import retrofit2.Response

class NewsRepository(
    val database: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse> =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchForNews(searchQuery: String, pageNumber: Int): Response<NewsResponse> =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun saveArticle(article: Article) =
        database.getArticleDao().upsert(article)

    fun getSavedNews() = database.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) =
        database.getArticleDao().deleteArticle(article)
}