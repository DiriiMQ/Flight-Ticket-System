package com.example.flightticket.components.BoardingPassComponents

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

data class InfoItem(val label: String, val value: String)

@Composable
fun PassengerInfo() {
    val infoItems = listOf(
        InfoItem(label = "Passenger", value = "1 Adult"),
        InfoItem(label = "Ticket", value = "NL82-1"),
        InfoItem(label = "Class", value = "Business"),
        InfoItem(label = "Seat", value = "2A")
    )

    Row(
        modifier = Modifier
            .padding(top =0.dp, end = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        infoItems.forEach { item ->
            Column(
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = item.label,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF065F46) // text-teal-800 equivalent
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.value,
                    fontSize = 16.sp,
                    color = Color(0xFF1A1A1A) // text-zinc-950 equivalent
                )
            }
        }
    }
}

@Preview
@Composable
fun PassengerInfoPreview() {
    PassengerInfo()
}