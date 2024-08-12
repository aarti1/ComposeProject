package com.example.myapplication.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.domain.usecases.app_entry.AppEntryUseCases
import com.example.myapplication.presentation.navgraph.NavGraph
import com.example.myapplication.presentation.onBoarding.OnBoardingScreen
import com.example.myapplication.presentation.onBoarding.OnBoardingViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       installSplashScreen().apply {
           setKeepOnScreenCondition(condition = {viewModel.splashCondition.value})
       }
        setContent {
            MyApplicationTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = viewModel.startDestination.value)

                }
            }
        }
    }
}

