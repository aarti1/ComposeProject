package com.example.myapplication.domain.usecases.news

import com.example.myapplication.db.NewsDao
import com.example.myapplication.domain.model.Article


class GetArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}