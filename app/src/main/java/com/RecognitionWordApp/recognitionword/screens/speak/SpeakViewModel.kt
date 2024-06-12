package com.RecognitionWordApp.recognitionword.screens.speak

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Locale

class SpeakViewModel:ViewModel(){
    private val _isOn = MutableStateFlow(false)
    val isOn: StateFlow<Boolean> = _isOn

    private val _showText = MutableStateFlow("Push button and talk")
    val showText: StateFlow<String> = _showText

    private val _language = MutableStateFlow("Russian")
    val language: StateFlow<String> = _language

    private val _languagePref = MutableStateFlow("ru")
    val languagePref: StateFlow<String> = _languagePref

    fun changeButton(){
        _isOn.value=!_isOn.value
    }
    fun changeText(text: String){
        _showText.value=text
    }
    fun changeLanguage(text: String){
        _language.value=text
        when(text){
            "Russian" ->_languagePref.value="ru"
            "English" ->_languagePref.value= Locale.ENGLISH.toString()
            "German" ->_languagePref.value=Locale.GERMAN.toString()

        }
    }
}