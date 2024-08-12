package com.example.myapplication.domain.usecases.news

import com.example.myapplication.db.NewsDao
import com.example.myapplication.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}