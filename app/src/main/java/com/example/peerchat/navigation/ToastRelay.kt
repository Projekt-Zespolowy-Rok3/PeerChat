package com.example.peerchat.navigation

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToastRelay @Inject constructor() {
    private val _toastEvents = MutableSharedFlow<ToastModel>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val toastEvents: SharedFlow<ToastModel> = _toastEvents.asSharedFlow()

    fun showToast(toastModel: ToastModel) {
        //bad, to change
        MainScope().launch {
            _toastEvents.emit(toastModel)
        }
    }
}

data class ToastModel(
    val message: String,
    val isError: Boolean = true
)