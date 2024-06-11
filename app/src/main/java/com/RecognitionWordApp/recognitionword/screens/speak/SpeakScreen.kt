package com.RecognitionWordApp.recognitionword.screens.speak

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.RecognitionWordApp.recognitionword.common.Speak

@Composable
fun SpeakScreen(navController: NavController, speakViewModel: SpeakViewModel= viewModel()){
    val isOn by speakViewModel.isOn.collectAsState()
    val showText by speakViewModel.showText.collectAsState()
    Speak(showText,isOn) { speakViewModel.changeButton() }
}