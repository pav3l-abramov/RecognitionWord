package com.RecognitionWordApp.recognitionword.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Main(
    text: String,
    onButton1: () -> Unit,
    onButton2: () -> Unit,
    onButton3: () -> Unit,
    onButton4: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text, fontSize = MaterialTheme.typography.headlineLarge.fontSize)

        Spacer(modifier = Modifier.size(50.dp))
        Button(onClick = { onButton1() }, modifier = Modifier.fillMaxWidth()) {
            Text("Speak", fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.size(50.dp))
        Button(onClick = { onButton2() }, modifier = Modifier.fillMaxWidth()) {
            Text("Image", fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.size(50.dp))
        Button(onClick = { onButton3() }, modifier = Modifier.fillMaxWidth()) {
            Text("Camera", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.size(50.dp))
        Button(onClick = { onButton4() }, modifier = Modifier.fillMaxWidth()) {
            Text("Scanner", fontSize = 30.sp)
        }
    }

}

@Preview
@Composable
fun check() {
    Main("text", {}, {}, {},{})
}