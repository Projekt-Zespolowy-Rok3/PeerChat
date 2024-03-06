package com.example.peerchat.presentation.createAccount

import com.example.peerchat.core.BaseViewModel
import com.example.peerchat.core.ViewModelEvent
import com.example.peerchat.core.ViewModelState
import com.example.peerchat.navigation.Destinations
import com.example.peerchat.navigation.DestinationsRelay
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    private val destinationsRelay: DestinationsRelay
) : BaseViewModel<CreateAccountViewState, CreateAccountScreenEvent>(
    initialState = CreateAccountViewState()
) {

    override fun handleEvent(event: CreateAccountScreenEvent) {
        when (event) {
            is CreateAccountScreenEvent.OnUsernameChanged -> TODO()
        }
    }
}

data class CreateAccountViewState(
    val username: String = ""
) : ViewModelState
sealed class CreateAccountScreenEvent : ViewModelEvent {
    data class OnUsernameChanged(val newUsername: String): CreateAccountScreenEvent()
}