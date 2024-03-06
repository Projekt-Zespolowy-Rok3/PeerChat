package com.example.peerchat.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface ViewModelState
interface ViewModelSideEffect
interface ViewModelEvent

abstract class BaseViewModel<State : ViewModelState, Event : ViewModelEvent>(
    initialState: State,
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    protected abstract fun handleEvent(event: Event)

    fun onEvent(event: Event) {
        handleEvent(event)
    }

    protected open fun updateState(action: (state: State) -> State) {
        _state.value = action(state.value)
    }
}
