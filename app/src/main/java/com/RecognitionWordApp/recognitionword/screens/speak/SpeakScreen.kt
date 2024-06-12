package com.RecognitionWordApp.recognitionword.screens.speak

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.RecognitionWordApp.recognitionword.common.Speak
import java.util.Locale

@Composable
fun SpeakScreen(
    navController: NavController,
    context: Context,
    speakViewModel: SpeakViewModel = viewModel()
) {
    val isOn by speakViewModel.isOn.collectAsState()
    val showText by speakViewModel.showText.collectAsState()

    val activityResultLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val res: ArrayList<String> =
                    data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                // Обработка результата распознавания речи здесь
                speakViewModel.changeText(res[0])
                speakViewModel.changeButton()
            }
        }

    Speak(
        showText,
        isOn,
        onButton = {
            speakViewModel.changeButton()
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault()
            )
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text")
            try {
                activityResultLauncher.launch(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, " " + e.message, Toast.LENGTH_LONG).show()
            }
        }
    )
}