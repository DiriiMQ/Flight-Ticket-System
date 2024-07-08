package com.example.flightticket.components.SeatComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R

@Composable
fun SeatGrid(selectedSeats: List<String>, onSeatSelect: (String) -> Unit) {
    val rows = listOf("A", "B", "C", "D")
    val seats = listOf(
        listOf("booked", "available", "booked", "available", "available", "booked", "available"),
        listOf("booked", "available", "available", "available", "booked", "booked", "available"),
        listOf("booked", "available", "available", "booked", "available", "booked", "available"),
        listOf("available", "booked", "available", "available", "available", "booked", "available")
    )

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        rows.forEachIndexed { rowIndex, row ->
            Column(
                modifier = Modifier.height(IntrinsicSize.Min),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = row, style = MaterialTheme.typography.bodyLarge)
                seats[rowIndex].forEachIndexed { seatIndex, seatState ->
                    val seatId = "$row${seatIndex + 1}"
                    val isSelected = selectedSeats.contains(seatId)
                    val backgroundColor = when {
                        isSelected -> colorResource(id = R.color.bg_selected)
                        seatState == "booked" -> colorResource(id = R.color.bg_booked)
                        else -> colorResource(id = R.color.bg_available)
                    }

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                color = backgroundColor,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable(enabled = seatState == "available") {
                                onSeatSelect(seatId)
                            }
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 56.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            (1..7).forEach { num ->
                Text(text = num.toString(), style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview
@Composable
fun SeatGridPreview() {
    SeatGrid(selectedSeats = listOf("A1", "B2", "C3", "D4")) {}
}