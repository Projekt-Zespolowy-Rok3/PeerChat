package com.example.peerchat.presentation.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WelcomeScreen(
    viewState: WelcomeScreenViewState, // In this case it's useless, I'm using it to demonstrate how it's usually used
    onEvent: (WelcomeScreenEvent) -> Unit
) {

    val onCreateAccountClicked: () -> Unit = remember {
        { onEvent(WelcomeScreenEvent.CreateAccountClicked) }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TextButton(
            modifier = Modifier.align(Alignment.Center),
            onClick = onCreateAccountClicked
        ) {
            Text(
                text = "Create an account",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}