package com.RecognitionWordApp.recognitionword.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.RecognitionWordApp.recognitionword.common.Main
import com.RecognitionWordApp.recognitionword.navigation.CAMERA_SCREEN
import com.RecognitionWordApp.recognitionword.navigation.IMAGE_SCREEN
import com.RecognitionWordApp.recognitionword.navigation.SPEAK_SCREEN

@Composable
fun MainScreen(navController: NavController) {
    Main(
        text = "Word recognition",
        onButton1 = { navController.navigate(route = SPEAK_SCREEN)},
        onButton2 = {navController.navigate(route = IMAGE_SCREEN)},
        onButton3 = {navController.navigate(route = CAMERA_SCREEN)},
    )
}