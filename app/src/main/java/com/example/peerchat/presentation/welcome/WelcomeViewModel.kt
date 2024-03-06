package com.example.peerchat.presentation.welcome

import com.example.peerchat.core.BaseViewModel
import com.example.peerchat.core.ViewModelEvent
import com.example.peerchat.core.ViewModelState
import com.example.peerchat.navigation.Destinations
import com.example.peerchat.navigation.DestinationsRelay
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(
    private val destinationsRelay: DestinationsRelay
) : BaseViewModel<WelcomeScreenViewState, WelcomeScreenEvent>(
    initialState = WelcomeScreenViewState
) {

    override fun handleEvent(event: WelcomeScreenEvent) {
        when (event) {
            WelcomeScreenEvent.CreateAccountClicked -> {
                destinationsRelay.navigateTo(Destinations.CreateAccountScreen)
            }
        }
    }
}

data object WelcomeScreenViewState : ViewModelState

sealed class WelcomeScreenEvent : ViewModelEvent {
    data object CreateAccountClicked : WelcomeScreenEvent()
}