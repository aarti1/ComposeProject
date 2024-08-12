package com.example.myapplication.presentation.bookmark

import com.example.myapplication.domain.model.Article


data class BookmarkState(
    val articles: List<Article> = emptyList()
)