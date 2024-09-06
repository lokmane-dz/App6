package me.lokmvne.app6.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.lokmvne.app6.repository.SocketScreenRepository
import javax.inject.Inject

@HiltViewModel
class SocketScreenViewModel @Inject constructor(
    private val repository: SocketScreenRepository
) : ViewModel() {
    val message = mutableStateOf("")

    fun onSendMessage(message: String) {
        viewModelScope.launch {
            repository.sendMessage(message)
        }
    }

    fun onDisconnect() {
        viewModelScope.launch {
            repository.disconnect()
        }
    }

    fun onConnect() {
        viewModelScope.launch {
            repository.connect()
        }
    }
}