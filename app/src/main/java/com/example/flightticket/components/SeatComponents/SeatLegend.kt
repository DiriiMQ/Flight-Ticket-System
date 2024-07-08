package com.example.flightticket.components.SeatComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R

@Composable
fun SeatLegend() {
    val legendItems = listOf(
        LegendItem("selected", "Selected", R.color.bg_selected),
        LegendItem("booked", "Booked", R.color.bg_booked),
        LegendItem("available", "Available", R.color.bg_available)
    )

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .height(IntrinsicSize.Min)
    ) {
        legendItems.forEach { item ->
            Row(
                modifier = Modifier.padding(end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = colorResource(id = item.colorResId),
                            shape = RoundedCornerShape(4.dp)
                        )
                )
                Text(
                    text = item.text,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp)
                )
            }
        }
    }
}

data class LegendItem(val state: String, val text: String, val colorResId: Int)

@Preview
@Composable
fun SeatLegendPreview() {
    SeatLegend()
}