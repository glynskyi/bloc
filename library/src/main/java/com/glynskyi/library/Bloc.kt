package com.glynskyi.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class Bloc<State, Event> : ViewModel() {

    private val events = Channel<Event>(Channel.UNLIMITED)

    private var _currentState = ConflatedBroadcastChannel(initialState)

    protected val currentState: ReceiveChannel<State>
        get() = _currentState.openSubscription()

    abstract val initialState: State

    abstract fun mapEventToState(event: Event): Flow<State>

    init {
        viewModelScope.launch(Dispatchers.Default) { runDispatchLoop() }
    }

    fun dispatch(event: Event) {
        events.offer(event)
    }

    private suspend fun runDispatchLoop() {
        for (event in events) {
            mapEventToState(event)
                .onEach(_currentState::send)
                .collect()
        }
    }
}