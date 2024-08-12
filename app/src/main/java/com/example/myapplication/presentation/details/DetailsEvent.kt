package com.example.myapplication.presentation.details

import com.example.myapplication.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}