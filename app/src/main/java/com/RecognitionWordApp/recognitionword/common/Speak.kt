package com.RecognitionWordApp.recognitionword.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.RecognitionWordApp.recognitionword.R

@Composable
fun Speak(
    text: String,
    buttonOn: Boolean,
    onButton: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.size(50.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text, fontSize = MaterialTheme.typography.headlineLarge.fontSize)
        }
        Spacer(modifier = Modifier.size(50.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth().height(100.dp)
        ) {
            Button(
                onClick = { onButton() }, shape = CircleShape,
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_mic_24),
                    contentDescription = null,
                    modifier = Modifier.size(if (buttonOn)100.dp else 60.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(50.dp))
    }
}


@Preview
@Composable
fun check2() {
    Speak("text", true, {})
}

