package com.RecognitionWordApp.recognitionword.screens.speak

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SpeakViewModel:ViewModel(){
    private val _isOn = MutableStateFlow(false)
    val isOn: StateFlow<Boolean> = _isOn

    private val _showText = MutableStateFlow("Push button and talk")
    val showText: StateFlow<String> = _showText

    fun changeButton(){
        _isOn.value=!_isOn.value
    }
    fun changeText(text: String){
        _showText.value=text
    }
}