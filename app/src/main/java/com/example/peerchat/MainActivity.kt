package com.example.peerchat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.peerchat.navigation.AppNavHost
import com.example.peerchat.navigation.Destinations
import com.example.peerchat.navigation.DestinationsRelay
import com.example.peerchat.presentation.common.PeerChatTheme
import com.kiwi.navigationcompose.typed.createRoutePattern
import com.kiwi.navigationcompose.typed.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    @Singleton
    lateinit var destinationsRelay: DestinationsRelay

    @OptIn(ExperimentalSerializationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PeerChatTheme {
                val navController = rememberNavController()
                val activityProvider: () -> AppCompatActivity = remember { { this } }

                HandleNavigationEvents(
                    destinationsRelay = destinationsRelay,
                    navController = navController,
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavHost(
                        startDestination = createRoutePattern<Destinations.WelcomeScreen>(),
                        navController = navController,
                        activity = activityProvider,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalSerializationApi::class)
@Composable
fun HandleNavigationEvents(
    destinationsRelay: DestinationsRelay,
    navController: NavController,
) {
    LaunchedEffect(key1 = Unit) {
        destinationsRelay.navigationEvents.collect { destination ->
            navController.navigate(destination)
        }
    }
}
