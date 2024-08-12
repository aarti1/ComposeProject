package com.example.myapplication.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.dimens.MediumPadding2

@Composable
fun HeaderTextComposable(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 16.sp,
        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
        color = colorResource(id = R.color.teal_200)
    )
}

@Composable
fun DescriptionTextComposable(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 14.sp,
        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Light),
        color = colorResource(id = R.color.purple_500)
    )
}