package com.example.peerchat.navigation

import com.kiwi.navigationcompose.typed.Destination
import kotlinx.serialization.Serializable


sealed interface Destinations : Destination {
    @Serializable
    data object WelcomeScreen : Destinations

    @Serializable
    data object CreateAccountScreen : Destinations
}