package com.example.flightticket.components.HomeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R
import com.example.flightticket.components.BookingsComponents.TransportContent

data class BookingOption(val imageRes: Int, val title: String, val onClick: () -> Unit = {})

@Composable
fun BookingCard(imageRes: Int, title: String, onClick: () -> Unit = {}) {
    Surface(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.1f)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "$title booking option",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Color.Black,
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 20.sp,
                    color = Color.Black
                )
            )
        }
    }
}

@Composable
fun HomeBookings(modifier: Modifier = Modifier, onTransportClick: () -> Unit = {}) {
    val bookingOptions = listOf(
        BookingOption(R.drawable.bk_hotel, "Hotel"),
        BookingOption(R.drawable.bk_transport, "Transport", onTransportClick),
        BookingOption(R.drawable.bk_trips, "Trips"),
        BookingOption(R.drawable.bk_events, "Events")
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(20.dp)
            .padding(bottom = 30.dp)
    ) {
        Text(
            text = "Booking",
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 24.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(bookingOptions) { option ->
//                BookingCard(imageRes = option.imageRes, title = option.title)
                if (option.title == "Transport") {
                    BookingCard(imageRes = option.imageRes, title = option.title, onClick = onTransportClick)
                } else {
                    BookingCard(imageRes = option.imageRes, title = option.title, onClick = { /* Handle other clicks */ })
                }
            }
        }

//        bookingOptions.forEach { option ->
//            BookingCard(imageRes = option.imageRes, title = option.title)
//        }
    }
}

@Composable
fun BookingsContent(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }

//    Column(
//        modifier = modifier
//            .fillMaxSize()
////            .padding(16.dp)
////            .background(color = colorResource(id = R.color.background_color))
//    ) {
//        HomeBookings()
//    }

    when (currentScreen) {
        "Home" -> HomeBookings(onTransportClick = { currentScreen = "Transport" })
        "Transport" -> TransportContent(
            onBackClick = { currentScreen = "Home" },
            onSearchClick = { currentScreen = "Search" }
        )
        // Add other screens as needed
    }
}

@Preview(showBackground = false)
@Composable
fun BookingsContentPreview() {
    BookingsContent(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
//            .background(color = colorResource(id = R.color.background_color))
    )
}