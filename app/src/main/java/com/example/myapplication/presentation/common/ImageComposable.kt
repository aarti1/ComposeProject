package com.example.myapplication.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun ImageComposable(
    modifier: Modifier = Modifier,
    img: Painter,
    contentDescription: String?,
    contentScale: ContentScale
) {
    Image(
        modifier = modifier,
        painter = img,
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}
