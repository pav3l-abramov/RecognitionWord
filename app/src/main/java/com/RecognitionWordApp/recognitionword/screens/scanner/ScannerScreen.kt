package com.RecognitionWordApp.recognitionword.screens.scanner


import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import com.RecognitionWordApp.recognitionword.common.Scanner
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ScannerScreen(context: Context, scannerViewModel: ScannerViewModel = viewModel()) {

    val imageUris by scannerViewModel.imageUris.collectAsState()
    val dateTimeFile =SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date()).toString() + ".pdf"
    val scannerLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult()) {
            if (it.resultCode == RESULT_OK) {
                val result = GmsDocumentScanningResult.fromActivityResultIntent(it.data)
                scannerViewModel.setImageUris(result?.pages?.map { it.imageUri } ?: emptyList())

                result?.pdf?.let { pdf ->
                    val fos = FileOutputStream(File(context.filesDir, dateTimeFile))
                    context.contentResolver.openInputStream(pdf.uri)?.use {
                        it.copyTo(fos)
                    }
                    scannerViewModel.savePdfFileToExternalStorage(context,File(context.filesDir,dateTimeFile))
                }


            }
        }

    Scanner(imageUris, onButton = {
        DocumentScanner().scanner.getStartScanIntent(context as Activity)
            .addOnSuccessListener {
                scannerLauncher.launch(
                    IntentSenderRequest.Builder(it).build()
                )
            }
            .addOnFailureListener {
                Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
            }
    })
}