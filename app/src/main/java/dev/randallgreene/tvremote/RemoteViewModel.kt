package dev.randallgreene.tvremote

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.*

class RemoteViewModel(application: Application) : AndroidViewModel(application) {

    private val ip: String
    private val url: String
    private val remoteRepository: RemoteRepository

    private val job = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.IO + job)

    init {
        val defaultIP = "192.168.1.160"
        val prefs = application.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
        ip = prefs.getString(IP_KEY, defaultIP) ?: defaultIP
        url = "http://$ip:5000"
        remoteRepository = RemoteRepository(url)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun sendPower() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.POWER)
    }

    fun sendVolumeUp() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.VOLUME_UP)
    }

    fun sendVolumeDown() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.VOLUME_DOWN)
    }

    fun sendChannelUp() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.CHANNEL_UP)
    }

    fun sendChannelDown() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.CHANNEL_DOWN)
    }

    fun sendMute() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.MUTE)
    }

    fun sendInput() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.INPUT)
    }

    fun sendUp() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.UP)
    }

    fun sendDown() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.DOWN)
    }

    fun sendRight() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.RIGHT)
    }

    fun sendLeft() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.LEFT)
    }

    fun sendSelect() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.SELECT)
    }

    fun sendZero() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.ZERO)
    }

    fun sendOne() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.ONE)
    }

    fun sendTwo() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.TWO)
    }

    fun sendThree() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.THREE)
    }

    fun sendFour() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.FOUR)
    }

    fun sendFive() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.FIVE)
    }

    fun sendSix() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.SIX)
    }

    fun sendSeven() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.SEVEN)
    }

    fun sendEight() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.EIGHT)
    }

    fun sendNine() = viewModelScope.launch {
        remoteRepository.sendButton(RemoteButton.NINE)
    }
}