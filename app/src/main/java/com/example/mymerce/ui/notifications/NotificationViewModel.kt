package com.example.mymerce.ui.notifications

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mymerce.domain.GreetingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val repository: GreetingRepository
) : ViewModel() {

    private val _greeting = mutableStateOf("")
    val greeting: State<String> = _greeting

    init {
        loadGreeting()
    }

    private fun loadGreeting() {
        _greeting.value = repository.getGreeting()
    }

    fun updateGreeting(newText: String) {
        _greeting.value = newText
    }
}

