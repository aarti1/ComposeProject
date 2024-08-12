package com.example.myapplication.presentation.onBoarding

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Dummy Text1 of the printing and typesetting industry.",
        description = "This is a dummy description1 of the text for printing and typesetting industry.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Dummy text2 of the printing and typesetting industry.",
        description = "This is a dummy description2 of the text for printing and typesetting industry.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Dummy text3 of the printing and typesetting industry.",
        description = "This is a dummy description3 of the text for printing and typesetting industry.",
        image = R.drawable.onboarding3
    )
    ,
    Page(
        title = "Dummy text4 of the printing and typesetting industry.",
        description = "This is a dummy description4 of the text for printing and typesetting industry.",
        image = R.drawable.onboarding2
    )
)