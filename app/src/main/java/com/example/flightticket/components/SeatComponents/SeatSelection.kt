package com.example.flightticket.components.SeatComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R
import com.example.flightticket.components.BoardingPassComponents.BoardingPass

@Composable
fun SeatSelection(onBackClick: () -> Unit = {}) {
    var selectedSeats by remember { mutableStateOf(listOf<String>()) }
    var currentScreen by remember { mutableStateOf("SeatSelection") }

    val handleSeatSelection: (String) -> Unit = { seat ->
        if (selectedSeats.contains(seat)) {
            selectedSeats = selectedSeats.filter { it != seat }
        } else if (selectedSeats.size < 2) {
            selectedSeats = selectedSeats + seat
        }
    }

    when (currentScreen) {
        "SeatSelection" -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            ) {
                Header(onBackClick = onBackClick)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                ) {
                    TravellerInfo(selectedSeats.size, 2)
                    SeatLegend()
                    SeatGrid(selectedSeats = selectedSeats, onSeatSelect = handleSeatSelection)
                    SeatSummary(selectedSeats = selectedSeats, numPeople = 2, unitPrice = 25.0, onSubmitClick = {
                        currentScreen = "SeatConfirmation"
                    })
                }
            }
        }
        "SeatConfirmation" -> {
            BoardingPass(onBackClick = onBackClick)
        }
    }
}

@Composable
fun Header(onBackClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(24.dp)
                .clickable(onClick = onBackClick)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Select Seats",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            color = colorResource(id = R.color.zinc_950)
        )
    }
}

@Composable
fun TravellerInfo(numSelected: Int, totalSeats: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Traveller",
            color = colorResource(id = R.color.zinc_950),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
        )
        Text(
            text = "$numSelected/$totalSeats",
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
        )
    }
}

// Assuming the composables SeatGrid, SeatLegend, and SeatSummary have been defined as per previous code examples

@Preview
@Composable
fun SeatSelectionPreview() {
    SeatSelection()
}
