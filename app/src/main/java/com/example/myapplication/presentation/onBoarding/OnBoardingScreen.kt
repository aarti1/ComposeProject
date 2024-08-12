package com.example.myapplication.presentation.onBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.common.ButtonComposableWithBorder
import com.example.myapplication.presentation.common.ButtonComposableWithoutBorder
import com.example.myapplication.presentation.dimens.MediumPadding2
import com.example.myapplication.presentation.onBoarding.components.OnBoardingPage
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen( onEvent: (OnBoardingEvent) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    pages.size - 1 -> listOf("Back", "Get Started")
                    else -> listOf("Back", "Next")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalPagerIndicator(
                modifier = Modifier.width(52.dp),
                pagesSize = pages.size,
                selectedPage = pagerState.currentPage
            )
            Spacer(modifier = Modifier.weight(1f))

            val scope = rememberCoroutineScope()
            if (pagerState.currentPage > 0) {
                ButtonComposableWithoutBorder(
                    text = buttonState.value[0],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage > 0) {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    }
                )
            }

            ButtonComposableWithBorder(
                text = buttonState.value[1],
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 3) {
                            //Navigate to the main screen and save a value in datastore preferences
                            onEvent(OnBoardingEvent.SaveAppEntry)
                        } else {
                            if (pagerState.currentPage < pages.size - 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }

                        }
                    }
                }
            )


        }
    }
}


