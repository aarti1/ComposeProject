package com.example.myapplication.domain.usecases.news

import com.example.myapplication.db.NewsDao
import com.example.myapplication.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }

}