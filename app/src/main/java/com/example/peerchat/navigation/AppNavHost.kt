package com.example.peerchat.navigation

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.peerchat.presentation.createAccount.CreateAccountScreen
import com.example.peerchat.presentation.createAccount.CreateAccountViewModel
import com.example.peerchat.presentation.welcome.WelcomeScreen
import com.example.peerchat.presentation.welcome.WelcomeScreenViewModel
import com.kiwi.navigationcompose.typed.composable
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
@Composable
internal fun AppNavHost(
    startDestination: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    activity: () -> AppCompatActivity,
    ) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable<Destinations.WelcomeScreen> {
            val viewModel: WelcomeScreenViewModel by activity().viewModels()
            val viewState by viewModel.state.collectAsState()

            WelcomeScreen(
                viewState = viewState,
                onEvent =viewModel::onEvent
            )
        }

        composable<Destinations.CreateAccountScreen> {
            val viewModel: CreateAccountViewModel by activity().viewModels()
            val viewState by viewModel.state.collectAsState()

            CreateAccountScreen(
                viewState = viewState,
                onEvent =viewModel::onEvent
            )
        }
    }
}
