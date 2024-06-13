package com.RecognitionWordApp.recognitionword.screens.scaner


import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import com.RecognitionWordApp.recognitionword.common.Scanner
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult
import java.io.File
import java.io.FileOutputStream

@Composable
fun ScannerScreen (context: Context, scannerViewModel:ScannerViewModel= viewModel()){

    val imageUris by scannerViewModel.imageUris.collectAsState()
//    val imageUris = remember {
//        mutableStateListOf<Uri>()
//    }
    val scannerLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult()) {
        if(it.resultCode ==RESULT_OK){
            val result = GmsDocumentScanningResult.fromActivityResultIntent(it.data)
            scannerViewModel.setImageUris(result?.pages?.map { it.imageUri } ?: emptyList())

            result?.pdf?.let { pdf ->
                val fos = FileOutputStream(File(context.filesDir,"scan.pdf"))
                context.contentResolver.openInputStream(pdf.uri)?.use {
                    it.copyTo(fos)
                }
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
                Toast.makeText(context, it.message,Toast.LENGTH_LONG).show()
            }
    })
}