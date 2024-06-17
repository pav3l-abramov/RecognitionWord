package com.RecognitionWordApp.recognitionword.navigation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.RecognitionWordApp.recognitionword.screens.camera.CameraScreen
import com.RecognitionWordApp.recognitionword.screens.image.ImageScreen
import com.RecognitionWordApp.recognitionword.screens.main.MainScreen
import com.RecognitionWordApp.recognitionword.screens.scanner.ScannerScreen
import com.RecognitionWordApp.recognitionword.screens.speak.SpeakScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(context: Context,serviceIntent:Intent) {
    val navController = rememberNavController()
   // val viewModel: SharedViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN
    ) {

        composable(route = MAIN_SCREEN) {
            MainScreen(navController = navController)
        }
        composable(route = CAMERA_SCREEN) {
            CameraScreen(navController = navController,context=context)
        }
        composable(route = IMAGE_SCREEN) {
            ImageScreen(navController = navController)
        }
        composable(route = SPEAK_SCREEN) {
            SpeakScreen(navController = navController,context=context, serviceIntent=serviceIntent)
        }
        composable(route = SCANNER_SCREEN) {
            ScannerScreen(context=context)
        }
    }
}