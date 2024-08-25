package com.android.template.presenter.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.template.domain.usecase.ExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel : ViewModel() {
    private val _navigateToHome = MutableStateFlow(false)
    val navigateToHome: StateFlow<Boolean> = _navigateToHome

    fun startTimer() {
        viewModelScope.launch {
            delay(2000)
            _navigateToHome.value = true
        }
    }
}