package com.example.myapplication.presentation.home


data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)