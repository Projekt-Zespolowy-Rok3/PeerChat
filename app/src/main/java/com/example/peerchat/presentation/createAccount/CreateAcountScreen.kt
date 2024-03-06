package com.example.peerchat.presentation.createAccount

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
import com.example.peerchat.navigation.Destinations

@Composable
fun CreateAccountScreen(
    viewState: CreateAccountViewState,
    onEvent: (CreateAccountScreenEvent) -> Unit
) {

    val onUsernameChanged: (String) -> Unit = remember {
        { newUsername -> onEvent(CreateAccountScreenEvent.OnUsernameChanged(newUsername = newUsername)) }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Create an account",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}