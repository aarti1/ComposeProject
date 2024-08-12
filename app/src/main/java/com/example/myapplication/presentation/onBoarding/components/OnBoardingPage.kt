package com.example.myapplication.presentation.onBoarding.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.presentation.common.DescriptionTextComposable
import com.example.myapplication.presentation.common.HeaderTextComposable
import com.example.myapplication.presentation.common.ImageComposable
import com.example.myapplication.presentation.dimens.MediumPadding2
import com.example.myapplication.presentation.onBoarding.Page

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier,
                   page: Page
) {
    Column(modifier = modifier) {
        ImageComposable(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f),
            img = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        HeaderTextComposable(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.title
        )

        DescriptionTextComposable(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.description
        )

    }
}


@Preview
@Composable
fun onBoardingPagePreview() {
    OnBoardingPage(
        page = Page(
            title = "Lorem Ipsum is simply dummy",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            image = R.drawable.onboarding1
        )
    )
}