package com.RecognitionWordApp.recognitionword.screens.scaner

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning

class DocumentScanner {
    val option = GmsDocumentScannerOptions.Builder()
        .setScannerMode(GmsDocumentScannerOptions.SCANNER_MODE_FULL)
        .setGalleryImportAllowed(true)
        .setResultFormats(
            GmsDocumentScannerOptions.RESULT_FORMAT_JPEG,
            GmsDocumentScannerOptions.RESULT_FORMAT_PDF
        )
        //.setPageLimit(5)
        .build()
    val scanner = GmsDocumentScanning.getClient(option)


}