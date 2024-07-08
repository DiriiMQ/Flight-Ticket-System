package com.example.flightticket.components.BoardingPassComponents

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DownloadButton() {
    val context = LocalContext.current

    Button(
        onClick = {
            Toast.makeText(context, "Ticket download initiated", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .height(50.dp)
            .background(color = Color(0xFFFFA500), shape = RoundedCornerShape(24.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA500))
    ) {
        Text(
            text = "Download ticket",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun DownloadButtonPreview() {
    DownloadButton()
}