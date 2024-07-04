package com.example.flightticket.components.HomeComponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationsContent() {
    Text(
        text = "Notifications",
        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(16.dp)
    )
}