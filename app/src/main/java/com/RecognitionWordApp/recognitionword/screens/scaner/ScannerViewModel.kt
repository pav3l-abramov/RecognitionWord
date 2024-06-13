package com.RecognitionWordApp.recognitionword.screens.scaner

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScannerViewModel:ViewModel() {
    private val _imageUris = MutableStateFlow<List<Uri>>(emptyList())
    val imageUris: StateFlow<List<Uri>> = _imageUris

    fun setImageUris (res:List<Uri>){
        _imageUris.value=res
    }
}