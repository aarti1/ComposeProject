package com.example.myapplication.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val getArticle: GetArticle,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val getArticles: GetArticles
)