package com.hardikmahant.chroniclingamerica.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hardikmahant.chroniclingamerica.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM Articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}