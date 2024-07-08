package com.example.flightticket.components.BookingsComponents

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightticket.components.SeatComponents.SeatSelection

@Composable
fun FlightList() {
    val dates = listOf(
        DateItem("TH", "02"),
        DateItem("FR", "03"),
        DateItem("SA", "04"),
        DateItem("SU", "05"),
        DateItem("MO", "06"),
        DateItem("TU", "07"),
        DateItem("WE", "08")
    )

    val flights = listOf(
        FlightInfo("NYC", "New York", "LDN", "London", "02 Jun", "9:00 AM", "$50", "NL-41"),
        FlightInfo("NYC", "New York", "LDN", "London", "02 Jun", "9:00 AM", "$50", "NL-41"),
        FlightInfo("NYC", "New York", "LDN", "London", "02 Jun", "9:00 AM", "$50", "NL-41")
    )

    var currentScreen by remember { mutableStateOf("FlightList") }

    when (currentScreen) {
        "FlightList" -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Flights", style = MaterialTheme.typography.titleLarge)
                DateSelector(dates)
                Text("3 flights available New York to London")
                flights.forEach { flight ->
                    FlightCard(
                        fromCode = flight.fromCode,
                        fromCity = flight.fromCity,
                        toCode = flight.toCode,
                        toCity = flight.toCity,
                        date = flight.date,
                        departure = flight.departure,
                        price = flight.price,
                        number = flight.number,
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = { currentScreen = "SeatSelection" }
                    )
                }
            }
        }

        "SeatSelection" -> {
            SeatSelection(onBackClick = { currentScreen = "FlightList" })
        }
    }
}

data class FlightInfo(
    val fromCode: String,
    val fromCity: String,
    val toCode: String,
    val toCity: String,
    val date: String,
    val departure: String,
    val price: String,
    val number: String
)

// Assume DateSelector and FlightCard composable functions are defined elsewhere

@Preview
@Composable
fun FlightListScreenPreview() {
    FlightList()
}
